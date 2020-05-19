package com.university.doctoronline;

import com.university.doctoronline.job.TimetableGenerationJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class DoctorOnlineApplicationTests {

    @Autowired
    private TimetableGenerationJob timetableGenerationJob;

    @Test
    void contextLoads() {
        timetableGenerationJob.generateTimeTable();
    }

}
