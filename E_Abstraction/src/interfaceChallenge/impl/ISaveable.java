package E_Abstraction.src.interfaceChallenge.impl;

import java.util.List;

public interface ISaveable {

    List<String> write();
    void read(List<String> words);
}
