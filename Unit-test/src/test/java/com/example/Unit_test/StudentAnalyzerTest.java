package com.example.Unit_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentAnalyzerTest {

    private StudentAnalyzer analyzer;

    @BeforeEach
    void init() {
        analyzer = new StudentAnalyzer();
    }

    // ==================================================
    // TEST CASES FOR countExcellentStudents
    // ==================================================

    @Test
    @DisplayName("TC-CE-01: Danh sách toàn bộ điểm hợp lệ")
    void testCountExcellentStudents_AllValidScores() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0, 7.5, 6.0);
        assertEquals(3, analyzer.countExcellentStudents(scores),
                "Phải đếm được 3 học sinh giỏi (8.0, 9.0, 10.0)");
    }

    @Test
    @DisplayName("TC-CE-02: Tất cả học sinh đều giỏi")
    void testCountExcellentStudents_AllExcellent() {
        List<Double> scores = Arrays.asList(8.0, 8.5, 9.0, 10.0);
        assertEquals(4, analyzer.countExcellentStudents(scores),
                "Tất cả điểm đều >= 8.0 nên phải trả về 4");
    }

    @Test
    @DisplayName("TC-CE-03: Không có học sinh giỏi")
    void testCountExcellentStudents_NoExcellent() {
        List<Double> scores = Arrays.asList(0.0, 5.0, 7.9);
        assertEquals(0, analyzer.countExcellentStudents(scores),
                "Không có điểm >= 8.0 nên kết quả phải là 0");
    }

    @Test
    @DisplayName("TC-CE-04: Có điểm âm")
    void testCountExcellentStudents_NegativeScore() {
        List<Double> scores = Arrays.asList(9.0, -1.0, 8.0);
        assertEquals(2, analyzer.countExcellentStudents(scores),
                "Điểm âm bị bỏ qua, còn lại 2 học sinh giỏi");
    }

    @Test
    @DisplayName("TC-CE-05: Có điểm lớn hơn 10")
    void testCountExcellentStudents_ScoreGreaterThanTen() {
        List<Double> scores = Arrays.asList(8.0, 11.0, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores),
                "Điểm > 10 bị bỏ qua, còn lại 2 học sinh giỏi");
    }

    @Test
    @DisplayName("TC-CE-06: Kết hợp điểm hợp lệ và không hợp lệ")
    void testCountExcellentStudents_MixedScores() {
        List<Double> scores = Arrays.asList(10.0, -2.0, 7.0, 11.0, 8.0);
        assertEquals(2, analyzer.countExcellentStudents(scores),
                "Chỉ đếm các điểm hợp lệ và >= 8.0");
    }

    @Test
    @DisplayName("TC-CE-07: Chỉ có điểm không hợp lệ")
    void testCountExcellentStudents_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-1.0, 12.0);
        assertEquals(0, analyzer.countExcellentStudents(scores),
                "Tất cả điểm không hợp lệ nên kết quả phải là 0");
    }

    @Test
    @DisplayName("TC-CE-08: Danh sách rỗng")
    void testCountExcellentStudents_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()),
                "Danh sách rỗng phải trả về 0");
    }

    @Test
    @DisplayName("TC-CE-09: Danh sách null")
    void testCountExcellentStudents_NullList() {
        assertEquals(0, analyzer.countExcellentStudents(null),
                "Danh sách null phải trả về 0");
    }

    @Test
    @DisplayName("TC-CE-10: Danh sách chứa giá trị null")
    void testCountExcellentStudents_ListContainsNull() {
        List<Double> scores = Arrays.asList(8.0, null, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores),
                "Giá trị null phải bị bỏ qua");
    }

    @Test
    @DisplayName("TC-CE-11: Boundary value 7.99 và 8.0")
    void testCountExcellentStudents_BoundaryLowerExcellent() {
        List<Double> scores = Arrays.asList(7.99, 8.0);
        assertEquals(1, analyzer.countExcellentStudents(scores),
                "Chỉ điểm 8.0 được tính là học sinh giỏi");
    }

    @Test
    @DisplayName("TC-CE-12: Boundary value 10.0")
    void testCountExcellentStudents_BoundaryUpperValid() {
        List<Double> scores = Arrays.asList(10.0);
        assertEquals(1, analyzer.countExcellentStudents(scores),
                "10.0 là điểm hợp lệ và là học sinh giỏi");
    }

    // ==================================================
    // TEST CASES FOR calculateValidAverage
    // ==================================================

    @Test
    @DisplayName("TC-AVG-01: Tất cả điểm hợp lệ")
    void testCalculateValidAverage_AllValidScores() {
        List<Double> scores = Arrays.asList(6.0, 8.0, 10.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores),
                "Trung bình phải là (6 + 8 + 10) / 3 = 8.0");
    }

    @Test
    @DisplayName("TC-AVG-02: Có điểm không hợp lệ")
    void testCalculateValidAverage_WithInvalidScores() {
        List<Double> scores = Arrays.asList(5.0, -1.0, 7.0);
        assertEquals(6.0, analyzer.calculateValidAverage(scores),
                "Chỉ tính điểm hợp lệ (5.0 và 7.0)");
    }

    @Test
    @DisplayName("TC-AVG-03: Chỉ có một điểm hợp lệ")
    void testCalculateValidAverage_SingleValidScore() {
        List<Double> scores = Arrays.asList(9.0);
        assertEquals(9.0, analyzer.calculateValidAverage(scores),
                "Chỉ có một điểm hợp lệ nên trung bình chính là điểm đó");
    }

    @Test
    @DisplayName("TC-AVG-04: Tất cả điểm không hợp lệ")
    void testCalculateValidAverage_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-1.0, 11.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores),
                "Không có điểm hợp lệ thì trung bình phải bằng 0");
    }

    @Test
    @DisplayName("TC-AVG-05: Danh sách rỗng")
    void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()),
                "Danh sách rỗng phải trả về 0.0");
    }

    @Test
    @DisplayName("TC-AVG-06: Danh sách null")
    void testCalculateValidAverage_NullList() {
        assertEquals(0.0, analyzer.calculateValidAverage(null),
                "Danh sách null phải trả về 0.0");
    }

    @Test
    @DisplayName("TC-AVG-07: Danh sách chứa giá trị null")
    void testCalculateValidAverage_ListContainsNull() {
        List<Double> scores = Arrays.asList(8.0, null, 6.0);
        assertEquals(7.0, analyzer.calculateValidAverage(scores),
                "Giá trị null phải bị bỏ qua khi tính trung bình");
    }

    @Test
    @DisplayName("TC-AVG-08: Boundary value 0.0 và 10.0")
    void testCalculateValidAverage_BoundaryValues() {
        List<Double> scores = Arrays.asList(0.0, 10.0);
        assertEquals(5.0, analyzer.calculateValidAverage(scores),
                "Trung bình của 0.0 và 10.0 phải là 5.0");
    }
}
