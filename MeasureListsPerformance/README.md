# MeasureListsPerformance #
Сравнить производительность ArrayList и LinkedList.  
  
Необходимо написать код, который бы вызывал основные методы коллекций определенное(1000 или 2000, или любое другое) количество раз. При этом должно засекаться время.
  
После этого вывести таблицу с результатами(метод, сколько раз выполнялся, время выполнения).

Количество вызовов метода: 1, 10, 50, 100, 1000, 2000, 10000.  

### Метод add(E e) ###
![addImage](https://user-images.githubusercontent.com/44549306/203795836-c4fdb69b-1782-4709-8de4-8dffe6b7c0d0.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListAdd              1  avgt    5         92,743 ±        87,374  ns/op
TestListsFunctions.arrayListAdd             10  avgt    4        738,822 ±       789,193  ns/op
TestListsFunctions.arrayListAdd             50  avgt    4       3608,171 ±      5342,431  ns/op
TestListsFunctions.arrayListAdd            100  avgt    5       6073,959 ±     10504,571  ns/op
TestListsFunctions.arrayListAdd            500  avgt    3      30852,858 ±    208528,475  ns/op
TestListsFunctions.arrayListAdd           1000  avgt    3      85337,557 ±   1212532,674  ns/op
TestListsFunctions.arrayListAdd           2000  avgt    3     355690,892 ±   8269171,599  ns/op
TestListsFunctions.arrayListAdd          10000  avgt    3     910713,846 ±   8840699,304  ns/op
TestListsFunctions.linkedListAdd             1  avgt    5        181,196 ±        21,574  ns/op
TestListsFunctions.linkedListAdd            10  avgt    5       1644,813 ±       317,163  ns/op
TestListsFunctions.linkedListAdd            50  avgt    5       8174,285 ±      2622,205  ns/op
TestListsFunctions.linkedListAdd           100  avgt    5      16604,874 ±      2933,093  ns/op
TestListsFunctions.linkedListAdd           500  avgt    5     120100,724 ±     14846,755  ns/op
TestListsFunctions.linkedListAdd          1000  avgt    5     261086,248 ±     15679,776  ns/op
TestListsFunctions.linkedListAdd          2000  avgt    5     522854,233 ±    327720,362  ns/op
TestListsFunctions.linkedListAdd         10000  avgt    5    2671384,506 ±   1733663,343  ns/op
```
### Метод add(int index, E element) ###
![addByIndexImage](https://user-images.githubusercontent.com/44549306/203795809-cc7d7163-6c5e-47bc-8422-089e897912cc.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListAddByIndex       1  avgt    5      28077,794 ±     25268,345  ns/op
TestListsFunctions.arrayListAddByIndex      10  avgt    5     285494,731 ±    278077,741  ns/op
TestListsFunctions.arrayListAddByIndex      50  avgt    5    1638396,952 ±   1844474,385  ns/op
TestListsFunctions.arrayListAddByIndex     100  avgt    5    3021295,854 ±   3101171,709  ns/op
TestListsFunctions.arrayListAddByIndex     500  avgt    5   14953738,673 ±   8888450,395  ns/op
TestListsFunctions.arrayListAddByIndex    1000  avgt    5   29360279,172 ±  30647947,405  ns/op
TestListsFunctions.arrayListAddByIndex    2000  avgt    5   59007507,074 ±  52634145,532  ns/op
TestListsFunctions.arrayListAddByIndex   10000  avgt    5  307220478,333 ± 315694735,365  ns/op
TestListsFunctions.linkedListAddByIndex      1  avgt    5        176,067 ±        14,353  ns/op
TestListsFunctions.linkedListAddByIndex     10  avgt    5       1727,264 ±       106,216  ns/op
TestListsFunctions.linkedListAddByIndex     50  avgt    5       9225,555 ±      7135,598  ns/op
TestListsFunctions.linkedListAddByIndex    100  avgt    5      19606,967 ±      1500,426  ns/op
TestListsFunctions.linkedListAddByIndex    500  avgt    5     243151,679 ±    212969,001  ns/op
TestListsFunctions.linkedListAddByIndex   1000  avgt    5     776297,217 ±    117277,593  ns/op
TestListsFunctions.linkedListAddByIndex   2000  avgt    5    2925251,535 ±   1821005,308  ns/op
TestListsFunctions.linkedListAddByIndex  10000  avgt    5   64242885,946 ±  12995437,391  ns/op
```
### Метод addAll(Collection<? extends E> c) ###
![addAll](https://user-images.githubusercontent.com/44549306/203795804-a9209fd4-11b4-4a90-a28b-6ed4474d31bf.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListAddAll           1  avgt    5        261,536 ±       247,487  ns/op
TestListsFunctions.arrayListAddAll          10  avgt    5       1609,772 ±      2280,512  ns/op
TestListsFunctions.arrayListAddAll          50  avgt    5      10425,627 ±     34319,962  ns/op
TestListsFunctions.arrayListAddAll         100  avgt    5      12256,310 ±     27564,124  ns/op
TestListsFunctions.arrayListAddAll         500  avgt    5      62727,111 ±    142018,809  ns/op
TestListsFunctions.arrayListAddAll        1000  avgt    5     266881,025 ±   1011647,633  ns/op
TestListsFunctions.arrayListAddAll        2000  avgt    5     411779,029 ±   1272743,907  ns/op
TestListsFunctions.arrayListAddAll       10000  avgt    5    1598299,533 ±   3485663,167  ns/op
TestListsFunctions.linkedListAddAll          1  avgt    5        186,484 ±        80,660  ns/op
TestListsFunctions.linkedListAddAll         10  avgt    5       1643,916 ±       181,737  ns/op
TestListsFunctions.linkedListAddAll         50  avgt    5       8146,686 ±      1390,970  ns/op
TestListsFunctions.linkedListAddAll        100  avgt    5      16117,037 ±      2276,247  ns/op
TestListsFunctions.linkedListAddAll        500  avgt    5      76797,771 ±     24625,508  ns/op
TestListsFunctions.linkedListAddAll       1000  avgt    5     162878,475 ±     21508,970  ns/op
TestListsFunctions.linkedListAddAll       2000  avgt    5     315476,229 ±     35982,999  ns/op
TestListsFunctions.linkedListAddAll      10000  avgt    5    1537010,262 ±   1011977,444  ns/op
```
### Метод clear() ###
![clearImage](https://user-images.githubusercontent.com/44549306/203795811-5221093a-65a7-4cff-a5f6-3af9cfeedb70.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListClear            1  avgt    5          1,792 ±         0,284  ns/op
TestListsFunctions.arrayListClear           10  avgt    5          1,798 ±         0,473  ns/op
TestListsFunctions.arrayListClear           50  avgt    5          1,786 ±         0,290  ns/op
TestListsFunctions.arrayListClear          100  avgt    5          1,963 ±         0,341  ns/op
TestListsFunctions.arrayListClear          500  avgt    5          2,546 ±         1,433  ns/op
TestListsFunctions.arrayListClear         1000  avgt    5          1,853 ±         0,880  ns/op
TestListsFunctions.arrayListClear         2000  avgt    5          1,764 ±         0,250  ns/op
TestListsFunctions.arrayListClear        10000  avgt    5          1,770 ±         0,272  ns/op
TestListsFunctions.linkedListClear           1  avgt    5          1,732 ±         0,074  ns/op
TestListsFunctions.linkedListClear          10  avgt    5          1,723 ±         0,187  ns/op
TestListsFunctions.linkedListClear          50  avgt    5          1,748 ±         0,203  ns/op
TestListsFunctions.linkedListClear         100  avgt    5          1,751 ±         0,184  ns/op
TestListsFunctions.linkedListClear         500  avgt    5          1,721 ±         0,206  ns/op
TestListsFunctions.linkedListClear        1000  avgt    5          1,727 ±         0,207  ns/op
TestListsFunctions.linkedListClear        2000  avgt    5          1,710 ±         0,071  ns/op
TestListsFunctions.linkedListClear       10000  avgt    5          1,772 ±         0,257  ns/op
```
### Метод remove(int index) ###
![removeImage](https://user-images.githubusercontent.com/44549306/203795824-c22776cb-8c37-4c8a-bc8a-bdd45fa25b10.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListRemove           1  avgt    5          1,057 ±         0,574  ns/op
TestListsFunctions.arrayListRemove          10  avgt    5          1,069 ±         0,678  ns/op
TestListsFunctions.arrayListRemove          50  avgt    5          0,998 ±         0,681  ns/op
TestListsFunctions.arrayListRemove         100  avgt    5          0,961 ±         0,509  ns/op
TestListsFunctions.arrayListRemove         500  avgt    5          1,038 ±         0,717  ns/op
TestListsFunctions.arrayListRemove        1000  avgt    5          0,954 ±         0,460  ns/op
TestListsFunctions.arrayListRemove        2000  avgt    5          0,967 ±         0,553  ns/op
TestListsFunctions.arrayListRemove       10000  avgt    5          0,963 ±         0,460  ns/op
TestListsFunctions.linkedListRemove          1  avgt    5          1,661 ±         1,994  ns/op
TestListsFunctions.linkedListRemove         10  avgt    5          1,389 ±         0,637  ns/op
TestListsFunctions.linkedListRemove         50  avgt    5          1,360 ±         0,770  ns/op
TestListsFunctions.linkedListRemove        100  avgt    5          1,371 ±         0,801  ns/op
TestListsFunctions.linkedListRemove        500  avgt    5          1,436 ±         0,975  ns/op
TestListsFunctions.linkedListRemove       1000  avgt    5          1,430 ±         0,698  ns/op
TestListsFunctions.linkedListRemove       2000  avgt    5          1,550 ±         0,549  ns/op
TestListsFunctions.linkedListRemove      10000  avgt    5          1,550 ±         1,010  ns/op
```
### Метод get(int index) ###
![getImage](https://user-images.githubusercontent.com/44549306/203795817-4fea75eb-3bd3-4748-83d9-a0242645b71b.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListGet              1  avgt    5          3,318 ±         1,037  ns/op
TestListsFunctions.arrayListGet             10  avgt    5         34,709 ±        35,021  ns/op
TestListsFunctions.arrayListGet             50  avgt    5        127,225 ±        17,892  ns/op
TestListsFunctions.arrayListGet            100  avgt    5        289,099 ±       139,539  ns/op
TestListsFunctions.arrayListGet            500  avgt    5       1236,382 ±       354,162  ns/op
TestListsFunctions.arrayListGet           1000  avgt    5       2357,063 ±       285,683  ns/op
TestListsFunctions.arrayListGet           2000  avgt    5       4780,881 ±       637,527  ns/op
TestListsFunctions.arrayListGet          10000  avgt    5      26514,521 ±      2800,253  ns/op
TestListsFunctions.linkedListGet             1  avgt    5          2,613 ±         0,303  ns/op
TestListsFunctions.linkedListGet            10  avgt    5         33,156 ±         3,582  ns/op
TestListsFunctions.linkedListGet            50  avgt    5        365,283 ±        52,156  ns/op
TestListsFunctions.linkedListGet           100  avgt    5       1494,514 ±       297,655  ns/op
TestListsFunctions.linkedListGet           500  avgt    5      54649,330 ±      1812,100  ns/op
TestListsFunctions.linkedListGet          1000  avgt    5     257761,005 ±     26564,991  ns/op
TestListsFunctions.linkedListGet          2000  avgt    5    1581663,720 ±    123820,083  ns/op
TestListsFunctions.linkedListGet         10000  avgt    5   64308239,814 ±   8621439,047  ns/op
```
### Метод size() ###
![sizeImage](https://user-images.githubusercontent.com/44549306/203795831-0936e29e-1dbf-4b6b-a16f-94074547a502.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListSize             1  avgt    5          1,341 ±         0,366  ns/op
TestListsFunctions.arrayListSize            10  avgt    5          1,635 ±         0,799  ns/op
TestListsFunctions.arrayListSize            50  avgt    5          2,168 ±         3,417  ns/op
TestListsFunctions.arrayListSize           100  avgt    5          2,137 ±         1,566  ns/op
TestListsFunctions.arrayListSize           500  avgt    5          3,225 ±         0,893  ns/op
TestListsFunctions.arrayListSize          1000  avgt    5          4,122 ±         3,104  ns/op
TestListsFunctions.arrayListSize          2000  avgt    5          3,534 ±         1,665  ns/op
TestListsFunctions.arrayListSize         10000  avgt    5          3,236 ±         1,467  ns/op
TestListsFunctions.linkedListSize            1  avgt    5          1,318 ±         0,142  ns/op
TestListsFunctions.linkedListSize           10  avgt    5          1,318 ±         0,180  ns/op
TestListsFunctions.linkedListSize           50  avgt    5          1,487 ±         0,548  ns/op
TestListsFunctions.linkedListSize          100  avgt    5          1,312 ±         0,119  ns/op
TestListsFunctions.linkedListSize          500  avgt    5          2,585 ±         0,258  ns/op
TestListsFunctions.linkedListSize         1000  avgt    5          2,586 ±         0,317  ns/op
TestListsFunctions.linkedListSize         2000  avgt    5          2,569 ±         0,296  ns/op
TestListsFunctions.linkedListSize        10000  avgt    5          2,592 ±         0,355  ns/op
```
### Метод indexOf(Object o) ###
![indexOfImage](https://user-images.githubusercontent.com/44549306/203941800-d45e8d72-4154-4860-b579-5f79ef6fb654.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListIndexOf          1  avgt    5          3,438 ±         0,810  ns/op
TestListsFunctions.arrayListIndexOf         10  avgt    5         83,120 ±        11,212  ns/op
TestListsFunctions.arrayListIndexOf         50  avgt    5       1184,630 ±        65,256  ns/op
TestListsFunctions.arrayListIndexOf        100  avgt    5       4355,846 ±       696,363  ns/op
TestListsFunctions.arrayListIndexOf        500  avgt    5     116081,975 ±     12448,100  ns/op
TestListsFunctions.arrayListIndexOf       1000  avgt    5     423915,667 ±     42001,745  ns/op
TestListsFunctions.arrayListIndexOf       2000  avgt    5    1771219,792 ±    370669,611  ns/op
TestListsFunctions.arrayListIndexOf      10000  avgt    5   92083575,825 ±  31938666,590  ns/op
TestListsFunctions.linkedListIndexOf         1  avgt    5          3,123 ±         0,819  ns/op
TestListsFunctions.linkedListIndexOf        10  avgt    5         77,613 ±        17,303  ns/op
TestListsFunctions.linkedListIndexOf        50  avgt    5       2355,674 ±       378,971  ns/op
TestListsFunctions.linkedListIndexOf       100  avgt    5       9027,894 ±       729,848  ns/op
TestListsFunctions.linkedListIndexOf       500  avgt    5     221110,595 ±     24043,536  ns/op
TestListsFunctions.linkedListIndexOf      1000  avgt    5    1120682,652 ±   1146470,807  ns/op
TestListsFunctions.linkedListIndexOf      2000  avgt    5    6350290,881 ±   4294850,719  ns/op
TestListsFunctions.linkedListIndexOf     10000  avgt    5  301434453,333 ± 411384726,506  ns/op
```
### Метод set(int index, E element) ###
![setImage](https://user-images.githubusercontent.com/44549306/203795828-80210daa-cfed-4a33-ac80-1ee917212429.png)
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListSet              1  avgt    5          5,101 ±         1,687  ns/op
TestListsFunctions.arrayListSet             10  avgt    5         44,878 ±         7,812  ns/op
TestListsFunctions.arrayListSet             50  avgt    5        313,510 ±       277,132  ns/op
TestListsFunctions.arrayListSet            100  avgt    5        702,364 ±       790,904  ns/op
TestListsFunctions.arrayListSet            500  avgt    5       3756,052 ±      4146,123  ns/op
TestListsFunctions.arrayListSet           1000  avgt    5       7938,422 ±      9916,129  ns/op
TestListsFunctions.arrayListSet           2000  avgt    5      15693,533 ±     17044,448  ns/op
TestListsFunctions.arrayListSet          10000  avgt    5      78058,689 ±     85738,843  ns/op
TestListsFunctions.linkedListSet             1  avgt    5          9,335 ±        11,178  ns/op
TestListsFunctions.linkedListSet            10  avgt    5         80,988 ±        32,295  ns/op
TestListsFunctions.linkedListSet            50  avgt    5        616,047 ±       374,303  ns/op
TestListsFunctions.linkedListSet           100  avgt    5       2195,878 ±      1125,711  ns/op
TestListsFunctions.linkedListSet           500  avgt    5      72726,291 ±      7442,455  ns/op
TestListsFunctions.linkedListSet          1000  avgt    5     301621,228 ±     18990,124  ns/op
TestListsFunctions.linkedListSet          2000  avgt    5    1417101,151 ±   1336920,547  ns/op
TestListsFunctions.linkedListSet         10000  avgt    5   64006706,618 ±   6466353,308  ns/op
```
### Метод contains(Object o) ###
#### Таблица результатов ####
```
Benchmark                                  (N)  Mode  Cnt          Score           Error  Units
TestListsFunctions.arrayListContains         1  avgt    5          3,593 ±         0,784  ns/op
TestListsFunctions.arrayListContains        10  avgt    5         75,518 ±        15,236  ns/op
TestListsFunctions.arrayListContains        50  avgt    5       1197,162 ±       355,906  ns/op
TestListsFunctions.arrayListContains       100  avgt    5       4190,587 ±      1208,179  ns/op
TestListsFunctions.arrayListContains       500  avgt    5     114430,078 ±     33336,956  ns/op
TestListsFunctions.arrayListContains      1000  avgt    5     398602,042 ±    105102,063  ns/op
TestListsFunctions.arrayListContains      2000  avgt    5    1643699,949 ±    520096,398  ns/op
TestListsFunctions.arrayListContains     10000  avgt    5   79067203,956 ±  20055957,321  ns/op
TestListsFunctions.linkedListContains        1  avgt    5          2,929 ±         0,392  ns/op
TestListsFunctions.linkedListContains       10  avgt    5         74,429 ±        10,963  ns/op
TestListsFunctions.linkedListContains       50  avgt    5       2186,576 ±       241,063  ns/op
TestListsFunctions.linkedListContains      100  avgt    5       9147,490 ±       825,468  ns/op
TestListsFunctions.linkedListContains      500  avgt    5     242253,540 ±    191589,417  ns/op
TestListsFunctions.linkedListContains     1000  avgt    5    1443691,847 ±    980382,167  ns/op
TestListsFunctions.linkedListContains     2000  avgt    5    6868191,581 ±   1280106,611  ns/op
TestListsFunctions.linkedListContains    10000  avgt    5  208373553,333 ±  42809756,972  ns/op
```
