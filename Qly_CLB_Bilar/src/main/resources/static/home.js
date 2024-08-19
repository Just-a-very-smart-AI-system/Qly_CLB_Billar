document.addEventListener("DOMContentLoaded", function() {
    function fetchRevenueData() {
        const token = localStorage.getItem('jwtToken');

        if (!token) {
            console.error("Không có token. Vui lòng đăng nhập.");
            return;
        }

        fetch('http://localhost:8080/bill/revenue/hourly/today', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        })
            .then(response => {
                console.log('Response status:', response.status); // Kiểm tra mã trạng thái
                if (!response.ok) {
                    throw new Error(`Network response was not ok, status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Data received:', data); // Kiểm tra dữ liệu nhận được
                updateChart(data);

            })
            .catch(error => console.error('Error fetching revenue data:', error));
    }

    function updateChart(data) {
        const bars = document.querySelectorAll('.chart-container .bar');

        // Giả sử `data` là một object với keys là các mốc thời gian và values là doanh thu
        const salesData = Object.values(data); // Lấy giá trị (doanh thu) từ object

        console.log('Sales Data:', salesData);

        const maxHeight = 400; // Chiều cao tối đa của trục y
        const maxSales = Math.ceil(Math.max(...salesData) / 100000) * 100000 ; // Doanh số tối đa được làm tròn lên

        // Cập nhật các label trên trục y
        const yAxisLabels = document.querySelectorAll('.y-axis .label');
        const step = maxSales / (yAxisLabels.length - 1);

        yAxisLabels.forEach((label, index) => {
            label.textContent = `${(index * step) / 1000}k`; // Chuyển đổi thành đơn vị 'k' cho dễ đọc
        });

        // Cập nhật chiều cao của các cột
        bars.forEach((bar, index) => {
            const sales = salesData[index] || 0;
            const height = (sales / maxSales) * maxHeight;
            const heightDiv = bar.querySelector('.height');
            heightDiv.style.height = height + 'px';
            heightDiv.textContent = `${sales / 1000}k`; // Hiển thị doanh thu trên cột
        });

        // Cập nhật tổng doanh thu
        const totalSales = salesData.reduce((sum, sales) => sum + sales, 0);
        const formattedSales = totalSales.toLocaleString('vi-VN') + ' đ';
        document.querySelector('.chart-container .chart-title p').textContent = formattedSales;
    }






    setInterval(fetchRevenueData, 3600000); // Cập nhật mỗi giờ
    fetchRevenueData(); // Gọi ngay khi trang được tải

    var logIn = document.querySelector('.LogInClient');
    var logInClose = document.querySelector('.LogInClient .close');
    var logInIcon = document.querySelector('.head_conten i#LogIn');
    var logInSubmit = document.querySelector('.LogInClient form button#Submit');
    document.querySelector('.head_conten p#User_Name').textContent = localStorage.getItem('Username');
    logInSubmit.onclick = function(event) {
        event.preventDefault();

        var usernameValue = document.querySelector('.LogInClient form input#username').value;
        var passwordValue = document.querySelector('.LogInClient form input#password').value;

        fetch('http://localhost:8080/auth/token', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                user_name: usernameValue,
                password: passwordValue
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok: ' + response.statusText);
                }
                return response.json(); // Giả sử server trả về JSON chứa token
            })
            .then(data => {
                console.log('Response Data:', data); // In ra phản hồi từ server

                if (data.token) {
                    localStorage.setItem('Username', usernameValue);
                    document.querySelector('.head_conten p#User_Name').textContent = localStorage.getItem('Username');

                    localStorage.setItem('jwtToken', data.token); // Lưu token vào localStorage
                    logIn.style.display = "none";
                } else {
                    console.error("Đăng nhập không thành công!");
                }
            })
            .catch(error => {
                console.error('Lỗi khi gửi yêu cầu đăng nhập:', error);
            });
    };

    logInClose.onclick = function(){
        logIn.style.display = "none";
    }
    logInIcon.onclick = function() {
        logIn.style.display = "flex";
    }





});
