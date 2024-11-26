package com.bank.atm.monitor.service;

import com.bank.atm.monitor.dto.MediaDTO;
import com.bank.atm.monitor.model.CameraMedia;
import com.bank.atm.monitor.repository.CameraMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CameraMediaService {
    @Autowired
    private CameraMediaRepository cameraMediaRepository;

    public List<MediaDTO> getMediaByTimeRange(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);

        List<CameraMedia> mediaFiles = cameraMediaRepository.findByTimestampBetween(start, end);

        return mediaFiles.stream()
                .map(media -> new MediaDTO(media.getMediaType(), media.getFilePath(),
                        media.getTimestamp().toString(), media.getAtmId()))
                .collect(Collectors.toList());
    }


    private Resource convertToResource(CameraMedia mediaFile) {
        try {
            return new UrlResource("file:" + mediaFile.getFilePath());
        } catch (IOException e) {
            throw new RuntimeException("Error converting file to resource: " + mediaFile.getFilePath(), e);
        }
    }
}
