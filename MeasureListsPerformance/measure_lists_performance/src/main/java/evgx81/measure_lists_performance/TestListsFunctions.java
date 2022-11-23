package evgx81.measure_lists_performance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

/**
 * Класс TestListsFunctions демонстрирует производительность коллекций ArrayList и LinkedList.
 * 
 * @author evgx81
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class TestListsFunctions {

    /**
     * Список чисел, которые характеризуют количество вызова метода.
     */
    @Param({"1", "10", "50", "100", "1000", "2000", "10000"})
    private int N;

    /**
     * Пустые листы, которые впоследствии будут заполнены объектами класса Integer.
     */
    private List<Integer> arrayListEmpty;
    private List<Integer> linkedListEmpty;

    /**
     * Листы, которые предполагаются заполненными объектами класса Integer.
     */
    private List<Integer> arrayListWithData;
    private List<Integer> linkedListWithData;

    /**
     * Коллекция, которая будет добавлена в arrayListEmpty.
     */
    Collection<Integer> arrayListCollection;

    /**
     * Коллекция, которая будет добавлена в linkedListEmpty.
     */
    Collection<Integer> linkedListCollection;

    /**
     * Функция вывода результатов тестирования.
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(TestListsFunctions.class.getSimpleName())
            .forks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(1))
            .measurementIterations(5)
            .measurementTime(TimeValue.seconds(1))
            .jvmArgs("-Xms1024m", "-Xmx2048m")
            .build();
        
        new Runner(opt).run();
    }

    /**
     * Конструктор по умолчанию для класса TestListsFunctions.
     */
    @Setup
    public void setup() {
        arrayListEmpty = new ArrayList<>();
        linkedListEmpty = new LinkedList<>();

        arrayListCollection = new ArrayList<>();
        linkedListCollection = new LinkedList<>();

        arrayListWithData = new ArrayList<>();
        linkedListWithData = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arrayListCollection.add(i);
            linkedListCollection.add(i);

            arrayListWithData.add(i);
            linkedListWithData.add(i);
        }
    }

    /**
     * Измеряем скорость добавления элемента в ArrayList.
     */
    @Benchmark
    public void arrayListAdd() {
        for (int i = 0; i < N; i++)
            arrayListEmpty.add(i);
    }

    /**
     * Измеряем скорость добавления элемента в LinkedList.
     */
    @Benchmark
    public void linkedListAdd() {
        for (int i = 0; i < N; i++)
            linkedListEmpty.add(i);
    }

    /**
     * Измеряем скорость добавления элемента по индексу в ArrayList.
     */
    @Benchmark
    public void arrayListAddByIndex() {
        for (int i = 0; i < N; i++)
            arrayListEmpty.add(i, i);
    }

    /**
     * Измеряем скорость добавления элемента по индексу в LinkedList.
     */
    @Benchmark
    public void linkedListAddByIndex() {
        for (int i = 0; i < N; i++)
            linkedListEmpty.add(i, i);
    }

    /**
     * Измеряем скорость добавления коллекции в ArrayList.
     */
    @Benchmark
    public void arrayListAddAll() {
        arrayListEmpty.addAll(arrayListCollection);
    }

    /**
     * Измеряем скорость добавления коллекции в LinkedList.
     */
    @Benchmark
    public void linkedListAddAll() {
        linkedListEmpty.addAll(linkedListCollection);
    }

     /**
     * Измеряем скорость очистки ArrayList.
     */
    @Benchmark
    public void arrayListClear() {
        linkedListWithData.clear();
    }

    /**
     * Измеряем скорость очистки LinkedList.
     */
    @Benchmark
    public void linkedListClear() {
        linkedListWithData.clear();
    }
}

