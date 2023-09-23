package pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces;

import pe.edu.upc.aaw.lawdingo_g4.entities.Subscription;

import java.util.List;

public interface ISubscriptionService {
    public void  create (Subscription subscription);
    public void  delete (int idSubscription);
    public List<Subscription> list(String name);

    public List<String[]> querieSubscription();


}
