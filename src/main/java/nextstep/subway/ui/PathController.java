package nextstep.subway.ui;

import lombok.RequiredArgsConstructor;
import nextstep.subway.application.dto.response.PathResponse;
import nextstep.subway.application.service.PathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/paths")
@RestController
@RequiredArgsConstructor
public class PathController {

    private final PathService pathService;


    @GetMapping
    public ResponseEntity<PathResponse> findPath(
        @RequestParam(name = "source") Long sourceStationId,
        @RequestParam(name = "target") Long targetStationId
    ) {
        return ResponseEntity.ok().body(pathService.findPath(sourceStationId, targetStationId));
    }

}