package com.example.dono;

public class FireBaseServises {
    private static FireBaseServises  instance;
    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;
    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

    public FireBaseServises ()
    {
        auth = FirebaseAuth.getInstance();
        fire = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
    }
    public static FireBaseServises  getInstance()
    {
        if (instance == null)
            instance = new FireBaseServises ();
        return instance;
    }
}
