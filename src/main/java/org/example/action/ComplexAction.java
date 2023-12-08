package org.example.action;

import org.example.bls.ReportFormatter;
import org.example.bls.ReportProvider;
import org.example.bls.ReportRepository;
import org.example.ds.FormattedReport;
import org.example.ds.Report;
import org.example.logging.PerformanceLogger;
import org.springframework.stereotype.Component;


@Component
public class ComplexAction {
    private final ReportFormatter reportFormatter;
    private final ReportProvider reportProvider;
    private final ReportRepository reportRepository;

    public ComplexAction(ReportFormatter reportFormatter, ReportProvider reportProvider, ReportRepository reportRepository) {
        this.reportFormatter = reportFormatter;
        this.reportProvider = reportProvider;
        this.reportRepository = reportRepository;
    }

    public void takeAction() {

        PerformanceLogger logger = new PerformanceLogger();

        PerformanceLogger.PerformanceLoggerInfo performanceLoggerInfo = logger.start("reportProvider.provideReport()");
        Report report = reportProvider.provideReport();
        logger.end(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("reportFormatter.format(report)");
        FormattedReport formattedReport = reportFormatter.format(report);
        logger.end(performanceLoggerInfo);

        performanceLoggerInfo = logger.start("reportRepository"+
                ".save(formattedReport)");
        reportRepository.save(formattedReport);
        logger.end(performanceLoggerInfo);
    }


}
