package mk.finki.ukim.mk.lab.service.implement;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.BalloonRepositoryImpl;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplement implements BalloonService {

    //inicijaliziranje na repo
    private final BalloonRepositoryImpl balloonRepository;

    public BalloonServiceImplement(BalloonRepositoryImpl repository) {
        this.balloonRepository = repository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Optional<Balloon> save(String name, String description, Long manufacturerId) {
        return this.balloonRepository.save(name, description, manufacturerId);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        this.balloonRepository.deleteById(id);
    }

}
