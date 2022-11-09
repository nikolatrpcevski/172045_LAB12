package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepositoryImpl {
    public List<Balloon> findAllBalloons() {
        return DataHolder.balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {

        return findAllBalloons().stream().filter(r->r.getName().contains("text") || r.getDescription().contains(text)).collect(Collectors.toList());

    }
    public void deleteById(Long id) {
        DataHolder.balloonList.removeIf(r -> r.getId().equals(id));
    }



    public Optional<Balloon> save(String name, String description, Long manufacturer) {
        DataHolder.balloonList.removeIf(r -> r.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer);
        DataHolder.balloonList.add(balloon);
        return Optional.of(balloon);
    }

}
