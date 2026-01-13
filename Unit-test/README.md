# Bài tập thực hành kiểm thử với JUnit 5

## Chủ đề: Phân tích dữ liệu điểm số học sinh

---

## 📋 Mô tả bài toán

Project Spring Boot **Unit-test** xây dựng lớp Java `StudentAnalyzer` nhằm phân tích dữ liệu điểm số học sinh và thực hành **Unit Testing với JUnit 5**.

Chương trình cung cấp hai phương thức chính:

### 1. `countExcellentStudents(List<Double> scores)`

* **Mục đích**: Đếm số lượng học sinh đạt loại **Giỏi** (điểm (>= 8.0))
* **Quy tắc xử lý**:

  * Chỉ chấp nhận điểm hợp lệ trong khoảng `[0, 10]`
  * Bỏ qua điểm âm, điểm lớn hơn 10 và giá trị `null`
  * Trả về `0` nếu danh sách rỗng hoặc `null`

### 2. `calculateValidAverage(List<Double> scores)`

* **Mục đích**: Tính **điểm trung bình** của các điểm hợp lệ
* **Quy tắc xử lý**:

  * Chỉ tính các điểm trong khoảng `[0, 10]`
  * Bỏ qua các điểm không hợp lệ và giá trị `null`
  * Trả về `0.0` nếu không tồn tại điểm hợp lệ nào

---

## 📁 Cấu trúc thư mục dự án

```text
Unit-test/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/Unit_test/
│   │           └── StudentAnalyzer.java
│   │
│   └── test/
│       └── java/
│           └── com/example/Unit_test/
│               └── StudentAnalyzerTest.java
│
├── pom.xml
└── README.md
```

---

## 🚀 Hướng dẫn chạy dự án

### Yêu cầu hệ thống

* **Java JDK 21**
* **Apache Maven 3.8+**

### Kiểm tra môi trường

```bash
java -version
mvn -version
```

### Biên dịch dự án

```bash
mvn clean compile
```

### Chạy Unit Test (JUnit 5)

```bash
mvn test
```

### Kết quả mong đợi

```text
[INFO] Tests run: 20, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

---

## 🧪 Danh sách Test Cases

### 1. Test cho `countExcellentStudents()`

| TC-ID    | Mô tả                               | Kết quả mong đợi |
| -------- | ----------------------------------- | ---------------- |
| TC-CE-01 | Danh sách toàn bộ điểm hợp lệ       | 3                |
| TC-CE-02 | Tất cả học sinh đều giỏi            | 4                |
| TC-CE-03 | Không có học sinh giỏi              | 0                |
| TC-CE-04 | Có điểm âm                          | 2                |
| TC-CE-05 | Có điểm > 10                        | 2                |
| TC-CE-06 | Kết hợp điểm hợp lệ và không hợp lệ | 2                |
| TC-CE-07 | Toàn bộ điểm không hợp lệ           | 0                |
| TC-CE-08 | Danh sách rỗng                      | 0                |
| TC-CE-09 | Danh sách null                      | 0                |
| TC-CE-10 | Danh sách chứa giá trị null         | 2                |
| TC-CE-11 | Boundary value 7.99 và 8.0          | 1                |
| TC-CE-12 | Boundary value 10.0                 | 1                |

---

### 2. Test cho `calculateValidAverage()`

| TC-ID     | Mô tả                       | Kết quả mong đợi |
| --------- | --------------------------- | ---------------- |
| TC-AVG-01 | Tất cả điểm hợp lệ          | 8.0              |
| TC-AVG-02 | Có điểm không hợp lệ        | 6.0              |
| TC-AVG-03 | Chỉ có một điểm hợp lệ      | 9.0              |
| TC-AVG-04 | Toàn bộ điểm không hợp lệ   | 0.0              |
| TC-AVG-05 | Danh sách rỗng              | 0.0              |
| TC-AVG-06 | Danh sách null              | 0.0              |
| TC-AVG-07 | Danh sách chứa giá trị null | 7.0              |
| TC-AVG-08 | Boundary value 0.0 và 10.0  | 5.0              |

---

## 🧠 Chiến lược kiểm thử

* **Unit Test thuần Java** (không load Spring Context)
* Áp dụng:

  * *Equivalence Partitioning*
  * *Boundary Value Analysis (BVA)*
* Framework sử dụng: **JUnit 5 (Jupiter)**

---

## 📌 Quản lý công việc (Issues)

| Issue | Mô tả                              | Trạng thái   |
| ----- | ---------------------------------- | ------------ |
| #1    | Cài đặt `countExcellentStudents()` | ✅ Hoàn thành |
| #2    | Cài đặt `calculateValidAverage()`  | ✅ Hoàn thành |
| #3    | Viết Unit Test cho hai hàm         | ✅ Hoàn thành |
| #4    | Hoàn thiện tài liệu README         | ✅ Hoàn thành |

---

## 🧾 Commit message mẫu

```bash
git commit -m "feat: implement countExcellentStudents #1"
git commit -m "feat: implement calculateValidAverage #2"
git commit -m "test: add unit tests for StudentAnalyzer #3"
git commit -m "docs: update README documentation #4"
```

---

## 👨‍💻 Tác giả

Bài tập thực hành – Môn **Kiểm thử Phần mềm**
Sinh viên: Bùi Ngọc Tuấn - BIT230426

---

## 📄 License

MIT License
