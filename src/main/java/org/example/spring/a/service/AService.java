package org.example.spring.a.service;

import com.example.demo.a.model.A;
import com.example.demo.a.model.ADto;
import org.example.spring.a.repository.ARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AService {
    private final ARepository aRepository;

    public void register(ADto.Register dto) {
        aRepository.save(dto.toEntity());
    }

    public List<ADto.ARes> list() {
        List<A> result = aRepository.findAll();

        return result.stream().map(ADto.ARes::from).toList();
    }

    public ADto.ARes read(Integer idx) {
        Optional<A> result = aRepository.findById(idx);

        if (result.isPresent()) {
            A entity = result.get();

            return ADto.ARes.from(entity);
        }

        return null;
    }

    public List<ADto.ARes> search(String a01) {
        List<A> result = aRepository.findByA01(a01);

        return result.stream().map(ADto.ARes::from).toList();
    }
}
