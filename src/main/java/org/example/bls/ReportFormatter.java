package org.example.bls;

import org.example.ds.FormattedReport;
import org.example.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportFormatter {
    public FormattedReport format(Report report) {
//        System.out.println(String.format("%s's format(Report report) is invoked"
//                ,this.getClass().getSimpleName()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(String.format("%s's format(Report report) is end."
//                    ,this.getClass().getSimpleName()));

        return new FormattedReport(report);
    }
}
