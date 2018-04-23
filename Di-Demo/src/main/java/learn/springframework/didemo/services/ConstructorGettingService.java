package learn.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorGettingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello  - I was just injected via the constructor!";
    }
}
