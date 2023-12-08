module com.example.practice_one {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.practice_one to javafx.fxml;
    exports com.example.practice_one;
    exports com.example.practice_one.page_118;
    opens com.example.practice_one.page_118 to javafx.fxml;
    exports com.example.practice_one.page_114;
    opens com.example.practice_one.page_114 to javafx.fxml;
    exports com.example.practice_one.page_132;
    opens com.example.practice_one.page_132 to javafx.fxml;
}