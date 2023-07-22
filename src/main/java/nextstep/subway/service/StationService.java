package nextstep.subway.service;

import nextstep.subway.domain.Station;
import nextstep.subway.domain.StationRepository;
import nextstep.subway.service.dto.StationRequest;
import nextstep.subway.service.dto.StationResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {
    private StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Transactional
    public StationResponse saveStation(StationRequest stationRequest) {
        final Station station = stationRepository.save(new Station(stationRequest.getName()));

        return StationResponse.fromEntity(station);
    }

    @Transactional(readOnly = true)
    public List<StationResponse> findAllStations() {
        return stationRepository.findAll().stream()
                .map(StationResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteStationById(Long id) {
        stationRepository.deleteById(id);
    }
}
