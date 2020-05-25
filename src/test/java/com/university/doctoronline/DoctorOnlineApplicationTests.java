package com.university.doctoronline;

import com.university.doctoronline.job.TimetableGenerationJob;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DoctorOnlineApplicationTests {

    @Autowired
    private TimetableGenerationJob timetableGenerationJob;

    @Test
    void contextLoads() {
    }

}
