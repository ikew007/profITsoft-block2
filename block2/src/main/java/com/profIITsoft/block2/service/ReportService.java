package com.profIITsoft.block2.service;

import com.profIITsoft.block2.dto.FlightDto;
import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Report service class to generate reports
 */
@Service
public class ReportService {

    /**
     * Generate CSV report for the provided flights.
     *
     * @param flights list of flights
     * @return CSV report
     * @throws IOException if an I/O error occurs
     */
    public byte[] generateCsvReport(List<FlightDto> flights) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter printer = new PrintWriter(out);

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("Flight Number", "Departure Airport", "Arrival Airport", "Departure Time", "Arrival Time")
                .build();

        try (CSVPrinter csvPrinter = new CSVPrinter(printer, format)) {
            for (FlightDto flight : flights) {
                csvPrinter.printRecord(
                        flight.getFlightNumber(),
                        flight.getDepartureAirport(),
                        flight.getArrivalAirport(),
                        flight.getDepartureTime(),
                        flight.getArrivalTime()
                );
            }
        }
        printer.flush();
        return out.toByteArray();
    }
}
