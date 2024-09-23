# Memories Project
## Mục lục
- [Giới thiệu](#giới-thiệu)
- [Tính năng](#tính-năng)
- [Yêu cầu](#yêu-cầu)
- [Git Conventional](#gitconventional)

## Giới thiệu
    Dự án "Memories" là một ứng dụng web được xây dựng bằng Java và Spring Boot. Mục tiêu của dự án là cung cấp một nền tảng để người dùng có thể lưu trữ, chia sẻ và quản lý những kỷ niệm đáng nhớ của họ.
## Tính năng
- Lưu trữ kỷ niệm: Người dùng có thể tạo và lưu lại những kỷ niệm dưới dạng văn bản hoặc hình ảnh.
- Chia sẻ kỷ niệm: Cho phép người dùng chia sẻ kỷ niệm của mình với bạn bè hoặc trên các nền tảng mạng xã hội.
- Xuất kỷ niệm: Người dùng có thể xuất kỷ niệm ra file PDF để lưu trữ hoặc chia sẻ dễ dàng hơn.
- Quản lý kỷ niệm: Người dùng có thể xem, chỉnh sửa hoặc xóa các kỷ niệm đã lưu.
- Phân loại kỷ niệm: Cho phép người dùng phân loại kỷ niệm theo thời gian, địa điểm hoặc chủ đề.
- Tìm kiếm kỷ niệm: Người dùng có thể tìm kiếm kỷ niệm dựa trên tiêu đề, nội dung hoặc thẻ gắn.
## Yêu cầu
- Java 8 hoặc cao hơn
- Maven 4.0.0
- Spring Boot 3.3.2
- MySQL hoặc SQLServer

## Git Conventional
<type>[optional scope]: <description>

[optional body]

[optional footer(s)]

- type: fix,feat,refactor,test,chore(không liên quan tới tính năng),docs,style,perf,revert.
- Sử dụng ! để đánh dấu quan trọng
feat! : memory create

- Scope: Phạm vi của commit, có thể là tên của một phần trong mã nguồn (tùy chọn).
- Description: Mô tả ngắn gọn về thay đổi (bắt buộc).
- Body: Thông tin chi tiết hơn về commit (tùy chọn).
- Footer: Có thể bao gồm thông tin bổ sung như BREAKING CHANGE để chỉ ra sự thay đổi lớn trong API.