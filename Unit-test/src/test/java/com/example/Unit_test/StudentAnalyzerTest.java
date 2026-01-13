package com.example.Unit_test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class StudentAnalyzerTest {

private StudentAnalyzer analyzer;

    @BeforeEach
    void init() {
        analyzer = new StudentAnalyzer();
    }
	// ===== countExcellentStudents =====

       @Test
    @DisplayName("Test đếm học sinh giỏi - Danh sách toàn bộ điểm hợp lệ")
    void testCountExcellentStudents_AllValidScores() {
        List<Double> scores = Arrays.asList(8.0, 9.0, 10.0, 7.5, 6.0, 5.0);

        assertEquals(3,analyzer.countExcellentStudents(scores),
                "Phải đếm được 3 học sinh giỏi (8.0, 9.0, 10.0)"
        );
    }

    @Test
    @DisplayName("Test đếm học sinh giỏi - Có điểm không hợp lệ")
    void testCountExcellentStudents_WithInvalidScores() {
        List<Double> scores = Arrays.asList(9.0, -1.0, 11.0, 8.0, 7.0);

        assertEquals(2,analyzer.countExcellentStudents(scores),
                "Phải bỏ qua điểm âm và > 10, chỉ còn 2 học sinh giỏi"
        );
    }

    @Test
    @DisplayName("Test đếm học sinh giỏi - Danh sách rỗng")
    void testCountExcellentStudents_EmptyList() {
        assertEquals(0,analyzer.countExcellentStudents(Collections.emptyList()),
                "Danh sách rỗng phải trả về 0"
        );
    }

    // ==================== TEST calculateValidAverage ======================

    @Test
    @DisplayName("Test tính điểm trung bình - Tất cả điểm hợp lệ")
    void testCalculateValidAverage_AllValidScores() {
        List<Double> scores = Arrays.asList(6.0, 8.0, 10.0);

        assertEquals(8.0,analyzer.calculateValidAverage(scores),
                "Điểm trung bình phải là (6 + 8 + 10) / 3 = 8.0"
        );
    }

    @Test
    @DisplayName("Test tính điểm trung bình - Có điểm không hợp lệ")
    void testCalculateValidAverage_WithInvalidScores() {
        List<Double> scores = Arrays.asList(5.0, -2.0, 12.0, 7.0);

        assertEquals(6.0,analyzer.calculateValidAverage(scores),
                "Chỉ tính điểm hợp lệ (5.0 và 7.0), trung bình = 6.0"
        );
    }

    @Test
    @DisplayName("Test tính điểm trung bình - Tất cả điểm không hợp lệ")
    void testCalculateValidAverage_AllInvalidScores() {
        List<Double> scores = Arrays.asList(-1.0, 11.0);

        assertEquals(0.0,analyzer.calculateValidAverage(scores),
                "Không có điểm hợp lệ thì trung bình phải bằng 0"
        );
    }
}
