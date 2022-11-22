package evgx81.measure_lists_performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
     * Список чисел, которые характеризуют сколько раз будет вызван метод.
     */
    @Param({"100", "200"})
    private int N;

    /**
     * Инициализируем пустые листы, которые впоследствии будут заполнены объектами класса String.
     */
    private List<String> arrayListEmpty;
    private List<String> linkedListEmpty;

    /**
     * Инициализируем листы, которые предполагаются заполненными объектами класса String.
     */
    private List<String> arrayListWithData;
    private List<String> linkedListWithData;

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

        arrayListWithData = new ArrayList<>();
        linkedListWithData = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arrayListWithData.add("data: " + i);
            linkedListWithData.add("data: " + i);
        }
    }
}

