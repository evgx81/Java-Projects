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
import org.openjdk.jmh.infra.Blackhole;
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
            .output("D:/code/Java/MeasureListsPerformance/benchmark.txt")
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
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListAdd(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            boolean res = arrayListEmpty.add(i);
            bh.consume(res);
        }
    }

    /**
     * Измеряем скорость добавления элемента в LinkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListAdd(Blackhole bh) {
        for (int i = 0; i < N; i++) {
            boolean res = linkedListEmpty.add(i);
            bh.consume(res);
        }
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
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListAddAll(Blackhole bh) {
        boolean res = arrayListEmpty.addAll(arrayListCollection);
        bh.consume(res);
    }

    /**
     * Измеряем скорость добавления коллекции в LinkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListAddAll(Blackhole bh) {
        boolean res = linkedListEmpty.addAll(linkedListCollection);
        bh.consume(res);
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

    /**
     * Измеряем скорость удаления элемента на определенной позиции в ArrayList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListRemove(Blackhole bh) {
        for (int i = 0; i < arrayListWithData.size(); i++) {
            Integer s = arrayListWithData.remove(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость удаления элемента на определенной позиции в LinkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListRemove(Blackhole bh) {
        for (int i = 0; i < linkedListWithData.size(); i++) {
            Integer s = linkedListWithData.remove(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость получения элемента на определенной позиции в ArrayList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListGet(Blackhole bh) {
        for (int i = 0; i < arrayListWithData.size(); i++) {
            Integer s = arrayListWithData.get(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость получения элемента на определенной позиции в LinkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListGet(Blackhole bh) {
        for (int i = 0; i < linkedListWithData.size(); i++) {
            Integer s = linkedListWithData.get(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость подсчета количества элементов в ArrayList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListSize(Blackhole bh) {
        Integer s = arrayListWithData.size();
        bh.consume(s);
    }

    /**
     * Измеряем скорость подсчета количества элементов в LinkedList.
     * 
     * @param bh требуется требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListSize(Blackhole bh) {
        Integer s = linkedListWithData.size();
        bh.consume(s);
    }

    /**
     * Измеряем скорость вычисления индекса элемента в ArrayList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListIndexOf(Blackhole bh) {
        for (int i = 0; i < arrayListWithData.size(); i++) {
            Integer s = arrayListWithData.indexOf(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость вычисления индекса элемента в linkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListIndexOf(Blackhole bh) {
        for (int i = 0; i < linkedListWithData.size(); i++) {
            Integer s = linkedListWithData.indexOf(i);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость замены элемента на определенной позиции заданным элементом в ArrayList.
     * 
     *  @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListSet(Blackhole bh) {
        for (int i = 0; i < arrayListWithData.size(); i++) {
            Integer s = arrayListWithData.set(i, i*10);
            bh.consume(s);
        }
    }

    /**
     * Измеряем скорость замены элемента на определенной позиции заданным элементом в LinkedList.
     * 
     *  @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListSet(Blackhole bh) {
        for (int i = 0; i < linkedListWithData.size(); i++) {
            Integer s = linkedListWithData.set(i, i*10);
            bh.consume(s);
        }
    }

     /**
     * Измеряем скорость проверки наличия элемента в ArrayList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void arrayListContains(Blackhole bh) {
        for (int i = 0; i < arrayListWithData.size(); i++) {
            boolean res = arrayListWithData.contains(i);
            bh.consume(res);
        }
            
    }

    /**
     * Измеряем скорость проверки наличия элемента в LinkedList.
     * 
     * @param bh требуется для устранения побочных эффектов.
     */
    @Benchmark
    public void linkedListContains(Blackhole bh) {
        for (int i = 0; i < linkedListWithData.size(); i++) {
            boolean res = linkedListWithData.contains(i);
            bh.consume(res);
        } 
    }
}

