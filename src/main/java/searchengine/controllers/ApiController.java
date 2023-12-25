package searchengine.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.services.IndexingService;

import searchengine.services.StatisticsService;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final IndexingService indexingServiceService;
    private final StatisticsService statisticsService;


    public ApiController(StatisticsService statisticsService,
                         IndexingService indexingServiceService) {
        this.statisticsService = statisticsService;
        this.indexingServiceService = indexingServiceService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(statisticsService.getStatistics());
    }

    @GetMapping("/startIndexing")
    public ResponseEntity<Boolean> startIndexing() {
        return ResponseEntity.ok(indexingServiceService.startIndexing());

    }


}