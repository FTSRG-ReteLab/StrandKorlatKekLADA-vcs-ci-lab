package hu.bme.mit.train.tachograph;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class TrainTachograph {
    Table<String, String, Integer> tacoTable;

    {
        tacoTable = TreeBasedTable.create();
    }
}
