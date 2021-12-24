package BOJ;///*
//
//public class Solution {
//
//    StringBuilder sb; StringTokenizer st;
//
//    public void solution() {
//        init();
//        solve();
//    }
//
//    void init() {
//        sb = null; st = null;
//
//        // 초기화
//    }
//
//    void solve() {
//        // 풀이 코드
//    }
//
//}
//
//// 테스트 코드 대입용 클래스 ( 제출할 때는 제거한다. )
//class Test {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solution();
//    }
//
//}
//
//< BufferedReader >
//많은 양의 입력이 있을 때는 scanner은 시간이 오래 걸린다. 따라서 빠른 시간 내에 입력을 할 수 있는 BufferedReader를 사용하자.
//사용 후에는 br.close()를 호출하여 스트림을 닫아줘야 한다.
//// 생성법
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//// 한줄 읽어오기
//// 라인 단위로 받으므로 받은 후 파싱해야 한다.
//String readLine()
//
//[ EOF 처리 ]
//while((input = br.readLine()) != null) {
//    //......
//}
//
//< BufferedWriter >
//많은 양의 출력이 있을 때는 println은 시간이 오래 걸린다. 따라서 빠른 시간 내에 출력을 할 수 있는 BufferedWriter를 사용하자.
//사용 후에는 bw.close()를 사용하여 스트림을 닫아줘야 한다.
//// 생성법
//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//// 버퍼에 문자열 쓰기
//// 자동 줄바꿈되지 않는다. => 맨끝에 직접 "\n"을 입력해줘야 한다.
//// 문자열만 인자로 받으므로 다른 자료형일 경우 String으로 형변환 후 넣어준다.
//void write(String s)
//
//// 플러시 : 버퍼에 담겨 있는 데이터를 내보낸다.
//// 버퍼에 데이터가 남아 있을 수 있기 때문에 마지막에 bw.flush()를 한번 해줘야 한다.
//void flush()
//
//< StringTokenizer >
//// 공백 문자를 기준으로 파싱한다.
//// 공백 문자는 토큰으로 간주하지 않는다.
//// 빈 문자열은 토큰으로 간주하지 않는다.
//StringTokenizer(String str) {}
//
//// 구분자를 지정해준다. 문자열이 길면 각 문자 하나하나가 모두 구분자가 된다.
//// ex) delim = "+-*/" 이면 4개가 전부 다 구분자가 되는 것이다.
//// 구분자를 토큰으로 간주하지 않는다.
//// 빈 문자열은 토큰으로 간주하지 않는다.
//        StringTokenizer(String str, String delim) {}
//
//// 구분자를 지정해준다. 문자열이 길면 각 문자 하나하나가 모두 구분자가 된다.
//// ex) delim = "+-*/" 이면 4개가 전부 다 구분자가 되는 것이다.
//// returnDelims 변수를 true로 설정하면 구분자도 토큰으로 간주한다.
//// 빈 문자열은 토큰으로 간주하지 않는다.
//        StringTokenizer(String str, String delim, boolean returnDelims)
//
//// 남은 토큰이 있는지 판별
//        boolean hasMoreTokens()
//
//// 다음 토큰 반환
//        String nextToken()
//
//// 토큰의 개수 반환
//        st.countTokens()
//
//        [ 사용 예시 ]
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//        st = new StringTokenizer(br.readLine());
//
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//
//        sb.append(a + b + "\n");
//        bw.write(sb.toString());
//        }
//
//< StringBuilder >
//문자열 조작시간을 크게 줄일 수 있다. 자바에서 문자열은 불변 객체로서 문자열이 바뀌면 내부 문자열 값이 바뀌는 것이 아니라 새로운 문자열을 생성하고, 그 문자열을 참조하게 만든다. 이 과정은 상당히 많은 시간이 소요되기 때문에 문자열의 추가 / 삭제가 잦은 경우 수행속도가 빠른 StringBuilder를 사용해야 한다.
//// 생성법
//        StringBuilder sb = new StringBuilder();
//
//// 모든 타입을 인자로 받을 수 있으며 타입의 모습 그대로 문자열에 추가해준다. (자동 줄바꿈 X)
//// 새로운 객체를 만들고 추가하는 것이 아니라 기존 것에서 추가하고 돌려준다.
//        StringBuilder append(String str)
//        ex)
//        sb.append('1');
//        sb.append(1);
//        sb.append(23.4);
//        sb.append("34"); // 1123.434
//
//// 문자열 삭제 : 문자열의 start ~ end - 1 위치의 문자열을 삭제. 새로운 객체를 만들고 삭제 후 반환하는 것이 아니라 기존 것에서 삭제하고 돌려준다.
//        StringBuilder delete(int start, int end)
//
//// 문자열의 길이 반환.
//        int length()
//
//// 문자열 뒤집기. 새로운 객체를 반환하는 것이 아니라 기존 것을 뒤집고 돌려준다.
//        StringBuilder reverse()
//
//// 문자열로 변환.
//        String str = sb.toString();
//
//        ** 어차피 기존 것을 계속 변경하는 것이므로, 굳이 반환 값을 변수에 받을 필요는 없다.
//
//< String 클래스 >
//// 문자열 인덱스
//char c = str.charAt(2);
//
//// 대문자 & 소문자 변환 : 당연히 불변 객체이므로 원본 값은 변경되지 않는다. 복제되어서 리턴된다.
//        String lower = str.toLowerCase();
//        String upper = str.toUpperCase();
//
//// 문자열 비교 : 사전순으로 비교한다. 같으면 0을, 사전순으로 왼쪽 문자열이 이전이면 음수, 이후면 양수 반환.
//        str.comparTo(str2);
//
//// 주어진 문자가 문자열에 내에 존재하는 첫번째 위치를 반환. 못 찾으면 -1 반환.
//        int idx = s.indexOf('o');
//
//// 문자열 내에서 지정한 문자를 다른 문자로 대체.
//// 당연히 불변 객체이므로 원본 값은 변경되지 않고 복제되어서 리턴된다.
//        String newStr = str.replace('a', 'x');
//
//// 문자열 내에서 지정한 문자열을 다른 문자열로 대체.
//// 당연히 불변 객체이므로 원본 값은 변경되지 않고 복제되어서 리턴된다.
//        String newStr = str.replace("asd", "x");
//
//// String substring(int index) : 문자열의 index 위치를 포함하여 그 이후의 모든 문자열을 새로운 문자열에 담아 반환.
//        String newstr = str.substring(2);
//
//// String substring(int beginIndex, int endIndex) : 문자열의 beginIndex ~ endIndex - 1 위치의 문자열을 새로운 문자열에 담아 반환.
//        String newstr = str.substring(2, 4);
//
//// static String format(String format, Object... args) : 문자열을 format 형식에 맞춰서 생성.
//        String result = String.format("w(%d, %d, %d) = %d\n", a, b, c, func(a, b, c));
//
//< Arrays 클래스 >
//// 지정한 배열의 모든 요소를 특정 값으로 초기화. 단, 참조형일 때는 이 메서드를 쓰면 안된다. 왜냐하면, 참조형의 경우 동일한 주소로 모든 데이터를 채우기 때문이다.
//static <T> void fill(T[] a, T val)
//
//// 객체의 comparable에 의해 from ~ to - 1 까지 정렬.
//// 기본형 타입 : 퀵 정렬 사용. O(N^2)
//// 참조형 타입 : 합병 정렬 사용. O(NlogN)
//static <T> void sort(T[] a, int fromIndex, int toIndex)
//
//// 지정한 Comparator에 의해 from ~ to - 1 까지 정렬.
//// 기본형 타입 : 퀵 정렬 사용. O(N^2)
//// 참조형 타입 : 합병 정렬 사용. O(NlogN)
//static <T> void sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
//
//// 전달받은 배열을 고정 크기의 리스트로 변환하여 반환. 읽기 전용이므로 조작 가능하게 하려면 아래와 같이 사용해야 한다. 기본형 타입은 사용할 수 없다.
//static <T> List<T> asList(T[] a)
//        ex)
//        Integer[] arr = new Integer[10];
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
//
//// 배열의 start ~ end - 1까지를 스트림으로 변환.
//static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)
//
//< Collections 클래스 >
//// 지정한 리스트의 모든 요소를 기본 Comparable에 의해 정렬.
//// 합병 정렬 사용. O(NlogN)
//static <T> void sort(List<T> list)
//
//// 지정한 리스트의 모든 요소를 Comparator에 의해 정렬
//// 합병 정렬 사용. O(NlogN)
//static <T> void sort(List<T> list, Comparator<T> c)
//
//// 컬렉션에서 최댓값 반환.
//static <T> T max(Collection<T> collection)
//        ex) int maxValue = Collections.max(list); // maxValue = 5
//
//// 컬렉션에서 최솟값 반환.
//static <T> T min(Collection<T> collection)
//        ex) int minValue = Collections.min(list); // maxValue = 5
//
//< ArrayList<E> 클래스 >
//        저장순서가 유지되고 중복을 허용한다.
//        데이터의 저장공간으로 배열을 사용한다.
//
//        [ 장점 ]
//        접근시간이 짧다.
//
//        [ 단점 ]
//        크기를 변경할 수 없다. ( 설정되어 있는 배열 크기를 넘어서면, 새로 리스트를 생성한다 )
//        데이터의 추가, 삭제에 시간이 많이 걸린다. ( 제일 뒤에 추가, 삭제하는 것이 아니라면 )
//// 저장된 객체 개수 반환.
//        int size()
//
//// 리스트가 비어있는지 확인.
//        boolean isEmpty()
//
//// 저장된 객체를 객체배열로 반환.
//        Object[] toArray()
//        ex) result.toArray(String[]::new);
//
//// 지정한 위치에 저장된 객체 반환.
//        E get(int index)
//
//// 지정한 객체를 추가.
//        boolean add(E e)
//
//// 지정한 위치의 객체 변경.
//        E set(int index, E element)
//
//// 지정한 위치에 있는 객체 삭제.
//        E remove(int index)
//
//// 모든 객체를 삭제.
//        void clear()
//
//< LinkedList<E> 클래스 >
//        저장순서가 유지되고 중복을 허용한다.
//        배열과 달리 불연속적으로 존재하는 데이터를 연결하는 방식이다.
//        더블 링크드 리스트 방식으로 구현되어 있다.
//
//        [ 장점 ]
//        데이터의 삭제 : 단 한번의 참조변경 만으로 가능하다.
//        데이터의 추가 : 한번의 Node 객체 생성과 두번의 참조 변경만으로 가능하다.
//
//        [ 단점 ]
//        접근 시간이 느리다.
//
//// 저장된 객체 개수 반환.
//        int size()
//
//// 리스트가 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 위치에 저장된 객체 반환.
//        E get(int index)
//
//// 지정한 위치에 객체 저장.
//        E set(int index, E element)
//
//// 지정한 객체를 추가.
//        boolean add(E e)
//
//// 지정한 객체를 특정 위치에 추가. 기존에 그 위치에 있던 것은 뒤로 밀려난다.
//        void add(int index, E element)
//
//// 지정한 위치에 있는 객체를 삭제하고, 삭제된 객체 반환.
//        E remove(int index)
//
//< hashSet<E> 클래스 >
//        객체를 저장하기 전에 equlas(), hashCode()를 호출해 기존에 같은 객체가 있는지 확인하고, 같은 객체가 없으면 저장하여 중복을 허용하지 않는다. 그렇기 때문에 equals()와 hashCode() 둘 다 오버라이딩 되어 있어야 한다.
//
//        List와 비교했을 때 단지 중복자료를 보관할 수 없다는 점 밖에 보이지 않지만 해쉬를 사용하기 때문에 검색 속도에 있어서 엄청난 차이를 보이기 때문에 많은 자료를 관리할 때는 HashSet 을 사용해야 한다.
//        HashSet으로 작성된 데이터는 값을 저장할 때 인스턴스의 해시값을 기준으로 저장하기 때문에 순서대로 저장되지 않기 때문에 순서대로 꺼낼 수 없고, Iterator를 활용해야 한다.
//
//        정렬되어 있지 않기 때문에 정렬을 하기 위해서는 List로 변환 후 Collections.sort()를 사용해야 한다.
//// 저장된 객체 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// iterator 반환.
//        Iterator<E> iterator()
//
//// 지정한 객체를 추가.
//        boolean add(E e)
//
//// 지정한 객체 삭제.
//        boolean remove(Object o)
//
//// 지정한 컬렉션이 포함되어 있는지 확인.
//        boolean containsAll(Collection<E> c)
//
//// 지정한 컬렉션을 추가. (합집합)
//        boolean addAll(Collection<E> c)
//
//// 지정한 컬렉션에 포함된 객체 삭제. (차집합)
//        boolean removeAll(Collection<E> c)
//
//// 지정한 컬렉션에 포함된 객체만 남기고 다른 객체들은 삭제. (교집합)
//        boolean retainAll(Collection<E> c)
//
//< TreeSet<E> 클래스 >
//        HashSet()은 동일한 값이 존재하는지를 판단할 떄 equals(), hashCode()를 사용하지만 TreeSet()은 Comparable 혹은 Comparator 인터페이스의 CompareTo() 메서드를 이용해 동일한 값이 존재하는지 판단한다. 값의 중복은 허용하지 않는다.
//
//        이진 탐색 트리 중 성능을 향상시킨 레드블랙트리로 구현하였기 때문에 정렬이 되어 있으며 범위 검색에 유리한 클래스지만, HashSet보다 데이터 추가, 삭제가 오래 걸린다.
//// 지정한 Comparator로 정렬하는 TreeSet을 생성.
//        TreeSet(Comparator<E> comparator)
//
//// 저장된 객체 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// iterator 반환.
//        Iterator<E> iterator()
//
//// 지정한 객체를 추가.
//        boolean add(E e)
//
//// 지정한 객체 삭제.
//        boolean remove(Object o)
//
//// Set에 지정한 컬렉션이 포함되어 있는지 확인.
//        boolean containsAll(Collection<E> c)
//
//// 지정한 컬렉션을 추가. (합집합)
//        boolean addAll(Collection<E> c)
//
//// 지정한 컬렉션에 포함된 객체 삭제. (차집합)
//        boolean removeAll(Collection<E> c)
//
//// 지정한 컬렉션에 포함된 객체만 남기고 다른 객체들은 삭제. (교집합)
//        boolean retainAll(Collection<E> c)
//
//// from ~ to에 해당하는 객체를 Set으로 반환.(양 끝 포함 설정하기)
//        SortedSet<E> subSet(E fromElement, boolean inclusive, E toElement, boolean inclusive)
//
//// 지정한 객체보다 작은 값의 객체들을 반환.(양 끝 포함 설정하기)
//        SortedSet<E> headSet(E toElement, boolean inclusive)
//
//// 지정한 객체와 같거나 보다 큰 값의 객체들을 반환.(양 끝 포함 설정하기)
//        SortedSet<E> tailSet(E fromElement, boolean inclusive)
//
//< 컬렉션 간의 장단점 비교 >
//        여기서 탐색이란 인덱스를 찾는게 아니라, 특정 객체를 찾는데 걸리는 시간을 말한다.
//
//        [ ArrayList ]
//        순서 보장 : O
//        중복 허용 : O
//        정렬 여부 : X
//        탐색 속도 : O(N)
//        삽입 속도 : O(1)
//        삭제 속도 : O(N)
//        ( + 인덱스 사용 가능 )
//
//        [ LinkedList ]
//        순서 보장 : O
//        중복 허용 : O
//        정렬 여부 : X
//        탐색 속도 : O(N)
//        삽입 속도 : O(1)
//        삭제 속도 : O(1)
//
//        [ HashSet ]
//        순서 보장 : X
//        중복 허용 : X
//        정렬 여부 : X
//        탐색 속도 : O(1)
//        삽입 속도 : O(1)
//        삭제 속도 : O(1)
//        범위 검색 : X
//
//        [ TreeSet ]
//        순서 보장 : X
//        중복 허용 : X
//        정렬 여부 : O
//        탐색 속도 : O(logN)
//        삽입 속도 : O(logN)
//        삭제 속도 : O(logN)
//        범위 검색 : O
//
//< HashMap<K, V> 클래스 >
//        key와 value의 쌍으로 이루어진 데이터 집합이며, 순서는 유지되지 않는다.
//        키는 중복을 허용하지 않으며, 값은 중복을 허용한다.
//        해싱기법으로 데이터를 저장하므로 데이터가 많아도 검색이 빠르다.
//
//        [ Map.Entry ]
//        key, value 쌍의 배열이다.
//
//// 생성법
//        HashMap<String, Integer> map = new HashMap<>();
//
//// 저장된 Entry 쌍의 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 key 객체와 일치하는 Map의 key 객체가 있는지 확인. O(1)
//        boolean containsKey(Object key)
//
//// 지정한 key 객체에 대응하는 value 객체를 반환. 없으면 null 반환.
//        V get(Object key)
//
//// value 객체를 key 객체에 연결하여 저장. 기존에 값이 있다면 덮어쓴다.
//        V put(K key, V value)
//
//// 지정한 key 객체를 포함하는 Entry 삭제.
//        V remove(Object key)
//
//// Map에 저장된 모든 key 객체를 Set으로 반환.
//        Set<K> keySet()
//
//// Map에 저장된 모든 value 객체를 Collection으로 반환.
//        Collection<V> values()
//
//// Map에 저장되어 있는 Entry 타입의 객체로 저장한 Set 반환.
//        Set<Map.Entry<K,V>> entrySet()
//
//< TreeMap<K, V> 클래스 >
//        key와 value의 쌍으로 이루어진 데이터 집합이며, 순서는 유지되지 않는다.
//        키는 중복을 허용하지 않으며, 값은 중복을 허용한다.
//        이진 탐색 트리 중 성능을 향상시킨 레드블랙트리로 구현하였기 때문에 정렬이 되어 있으며 범위 검색에 유리한 클래스지만, HashMap보다 데이터 추가, 삭제가 오래 걸린다.
//
//        정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 TreeMap을 사용하는 것이 좋다.
//// 지정한 Comparator로 정렬하는 TreeMap 생성.
//        TreeMap(Comparator<K> comparator)
//
//// 저장된 Entry 쌍의 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 key 객체와 일치하는 Map의 key 객체가 있는지 확인. O(1)
//        boolean containsKey(Object key)
//
//// 지정한 key 객체에 대응하는 value 객체를 반환.
//        V get(Object key)
//
//// value 객체를 key 객체에 연결하여 저장. 기존에 값이 있다면 덮어쓴다
//        V put(K key, V value)
//
//// 지정한 key 객체를 포함하는 Entry 삭제.
//        V remove(Object key)
//
//// Map에 저장된 모든 key 객체를 Set으로 반환.
//        Set<K> keySet()
//
//// Map에 저장된 모든 value 객체를 Collection으로 반환.
//        Collection<V> values()
//
//// Map에 저장되어 있는 Entry 타입의 객체로 저장한 Set 반환.
//        Set<Map.Entry<K,V>> entrySet()
//
//// from ~ to에 해당하는 Entry들을 Map으로 반환.(양 끝 포함 설정하기)
//        Map<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
//
//// 지정한 객체보다 작은 값의 Entry들을 반환.(양 끝 포함 설정하기)
//        Map<K, V> headMap(K toKey, boolean inclusive)
//
//// 지정한 객체와 같거나 보다 큰 값의 Entry를들을 반환.(양 끝 포함 설정하기)
//        Map<K, V> tailMap(K fromKey, boolean inclusive)
//
//< 맵 간의 장단점 비교 >
//        [ HashMap ]
//        순서 보장 : X
//        중복 허용 : X
//        정렬 여부 : X
//        탐색 속도 : O(1)
//        삽입 속도 : O(1)
//        삭제 속도 : O(1)
//        범위검색 : X
//
//        [ TreeMap ]
//        순서 보장 : X
//        중복 허용 : X
//        정렬 여부 : O
//        탐색 속도 : O(logN)
//        삽입 속도 : O(logN)
//        삭제 속도 : O(logN)
//        범위 검색 : O
//
//< Iterator<E> 인터페이스 >
//        컬렉션에 저장된 데이터를 접근하는데 사용되는 인터페이스이다.
//        읽어오는 방법을 컬렉션 종류와 상관없이 표준화했다는 것에 사용의미가 있다.
//
//        [ Map과 Iterator ]
//        Map에는 Iterator가 없다. 컬렉션의 자손이 아니기 때문이다.
//        keySet(), entrySet(), values()를 호출해서 컬렉션을 얻은 다음 iterator를 사용해야 한다.
//        HashMap<String, Integer> map = new HashMap();
//        Iterator<String> iterator = map.keySet().iterator();
//
//// 현재 위치에 요소가 남아있는지 확인.
//        boolean hasNext()
//
//// 현재 위치의 요소를 반환 후 다음 위치로 감.
//// 호출 전에 hasNext()를 통해 확인하는 것이 안전하다.
//        E next()
//
//// 현재 위치에 해당하는 객체를 삭제. 삭제 후 데이터는 하나씩 당겨지지만 커서는 다음으로 가지 않는다. => 다음 데이터를 지나치지 않는다.
//        void remove()
//
//< ListIterator<E> 인터페이스 >
//        Iterator의 접근성을 향상시킨 것이다.(단방향 -> 양방향)
//// 현재 위치에 요소가 남아있는지 확인.
//        boolean hasNext()
//
//// 현재 위치의 요소를 반환 후 다음 위치로 감.
//// 호출 전에 hasNext()를 통해 확인하는 것이 안전하다.
//        E next()
//
//// 이전 위치에 요소가 남아 있는지 확인.
//        boolean hasPrevious()
//
//// 이전 위치의 요소를 반환 후 이전 위치로 감.
//// 호출 전에 hasPrevious()를 통해 확인하는 것이 안전하다.
//        E previous()
//
//// 현재 위치에 해당하는 객체를 삭제. 삭제 후 데이터는 하나씩 당겨지지만 커서는 다음으로 가지 않는다. => 다음 데이터를 지나치지 않는다.
//        void remove()
//
//< Stack<E> 클래스 >
//// 생성법
//        Stack<Integer> stack = new Stack<>();
//
//// 스택이 비어있는지 확인.
//        boolean isEmpty()
//
//// 객체를 저장한다.
//        E push(E item)
//
//// 맨 위에 저장된 객체를 꺼낸다.
//        E pop()
//
//// 제일 위에 저장된 객체를 반환. pop과 달리 스택에서 객체를 꺼내지는 않는다.
//        E peek()
//
//< Queue<E> 인터페이스 >
//// 생성법
//        Queue<Integer> dq = new LinkedList<>();
//
//// 저장된 객체 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 객체를 추가. 성공하면 true.
//        boolean offer(E e)
//
//// 제일 앞 객체를 꺼내 반환. 비어있으면 null 반환.
//        E poll()
//
//// 제일 앞에 저장된 객체를 반환. poll과 달리 객체를 꺼내지는 않는다.
//        E peek()
//
//< Deque<E> 인터페이스 >
//// 생성법
//        Deque<Integer> dq = new LinkedList<>();
//
//// 저장된 객체 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 객체를 제일 앞에 추가. 성공하면 true.
//        boolean offerFirst(E e)
//
//// 지정한 객체를 제일 뒤에 추가. 성공하면 true.
//        boolean offerLast(E e)
//
//// 제일 앞 객체를 꺼내 반환. 비어있으면 null 반환.
//        E pollFirst()
//
//// 제일 뒤 객체를 꺼내 반환. 비어있으면 null 반환.
//        E pollLast()
//
//// 제일 앞에 저장된 객체를 반환. poll과 달리 객체를 꺼내지는 않는다.
//        E peekFirst()
//
//// 제일 뒤에 저장된 객체를 반환. poll과 달리 객체를 꺼내지는 않는다.
//        E peekLast()
//
//< PriorityQueue<E> 클래스 >
//// 지정한 Comparator로 우선순위를 설정하는 PriorityQueue 생성.
//        PriorityQueue(Comparator<E> comparator)
//
//// 저장된 객체 개수 반환.
//        int size()
//
//// 비어있는지 확인.
//        boolean isEmpty()
//
//// 지정한 객체를 추가. 성공하면 true.
//        boolean offer(E e)
//
//// 제일 높은 우선순위의 객체를 꺼내 반환. 비어있으면 null 반환.
//        E poll()
//
//// 제일 높은 우선순위의 객체를 반환. poll과 달리 객체를 꺼내지는 않는다.
//        E peek()
//
//< Comparable & Comparator 인터페이스 >
//        객체 정렬에 필요한 메서드를 정의한 인터페이스이다.
//        Comparable : 클래스의 기본 정렬 기준을 구현하는데 사용한다.
//        Comparator : 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용한다.
//public interface Comparable {
//
//    int compareTo(Object o);
//
//}
//
//public interface Comparator {
//
//    int compare(Object o1, Object o2);
//
//}
//    두 객체의 비교결과를 반환하도록 작성해야 한다.
//        (디폴트) 같으면 0, 좌우 위치를 유지하려면 음수, 바꾸려면 양수를 반환한다.
//
//        주로 문제에서 주어지는 조건대로 정렬하기 위해 Comparable을 구현하는 방식을 사용하지 않고, 정렬과 동시에 익명 Comparator를 만들어서 정렬한다.
//
//< Math 클래스 >
//static T max(T a , T b) : 둘 중 큰값을 리턴
//static T min(T a , T b) : 둘 중 작은값을 리턴
//static double pow(double a, double b) : a의 b제곱.
//static long round(double a) : 소수점 첫째 자리에서 반올림.
//
//        [ 특정 자리에서 반올림 ]
//// 반올림하여 소수점 아래 pos자리 까지 나타냄.
//static Double myRound(Double num, int pos) {
//        int multiple = 1;
//        while(pos-- > 0)multiple *= 10;
//
//        return Math.round(num * multiple) / (double)multiple;
//        }
//
//< 정렬 >
//quick sort : 평균 : O(NlogN), 최악 : O(N^2) => 사용 X.
//        merge sort : 평균 : O(NlogN), 최악 : O(NlogN) => 사용해야 한다.
//
//        [ Arrays.sort() ]
//        기본형 타입 : 퀵 정렬 사용.
//        참조형 타입 : 합병 정렬 사용.
//
//        => 기본형 타입의 배열일 경우 느리기 때문에 래퍼 클래스로 변환하거나, 컬렉션으로 바꾼 후 정렬하자!
//        int[] arr = new int[1005];
//        arr = Arrays.stream(arr, 0, n)
//        .boxed()
//        .sorted()
//        .mapToInt(i -> i)
//        .toArray();
//
//        [ Collections.sort() ]
//        합병정렬 사용.
//
//< 기본형 배열과 래퍼형 배열 간의 변환 >
//        [ 기본형 배열 -> 래퍼형 배열 ]
//        int[] arr = new int[1000];
//        Integer[] newArr = Arrays.stream(arr, 0, n)
//        .boxed()
//        .toArray(Integer[]::new);
//
//        [ 래퍼형 배열 -> 기본형 배열 ]
//        Integer[] arr = new Integer[1000];
//        int[] newArr = Arrays.stream(arr, 0, n)
//        .mapToInt(i -> i)
//        .toArray();
//
//< 형변환 >
//// 정수 -> 문자열
//String str = 3 + "";
//
//// 문자열 -> 정수
//        int x = Integer.parseInt("123");
//
//// 문자 -> 문자열
//        String s = 'a' + "";
//
//// 문자열 -> 문자
//        String s = "a";
//        char c = s.charAt(0);
//
//        [ 강제 형변환 ]
//        변수를 감싸는 것이 아니라 타입을 괄호로 감싸주는 것이다.
//        int a = (int)'c';
//        int a = (int)('a' + 'c');
//
//< 둘 이상의 반복문 벗어나기 >
//        반복문에 이름을 붙여서 둘 이상의 반복문을 벗어날 수 있다.
//        loop1 : for(int i = 1;i < 10;i++) {
//        for(int j = 1;j < 10;j++) {
//        if(j == 5)break loop1;
//        }
//        }
//
//< 배열 초기화 >
//배열을 전역에 선언하면 기본값으로 자동 초기화된다.
//        ex) int[] : 0으로 초기화, Integer[] : null로 초기화.
//
//        [ 기본형 배열 초기화 ]
//// 1차원
//        int[] arr = new int[50];
//        Arrays.fill(arr, -1);
//
//// 2차원
//        int[][] arr = new int[50][50];
//        for(int i = 0;i < 50;i++)Arrays.fill(arr[i], -1);
//
//// 3차원
//        int[][][] arr = new int[50][50][50];
//        for (int i = 0; i < 50; i++) for (int j = 0; j < 50; j++) Arrays.fill(arr[i][j], -1);
//
//        [ 참조형 배열 초기화 ]
//        객체의 배열을 생성하고 나면 각 객체를 담을 주소가 생성되는 것이지 실제 객체가 생성되는 것이 아니다. 따라서 각 인덱스마다 객체를 생성해줘야 한다.
//
//        ** < 주의 >
//참조형 데이터를 채울 때 Arrays.fill() 메서드를 사용하면 안된다. 아래의 코드를 예로 들면, 하나의 ArrayList 객체를 생성해서 그 주소로 메서드 파라미터가 치환되어, 모든 데이터가 동일한 ArrayList를 공유하게 되는 것이다.
//        Arrays.fill(adj, new ArrayList<>());
//
//        따라서 아래와 같이 반복문을 돌려서 초기화 시키자.
//// 1차원
//        Pair[] arr = new Pair[50];
//        for(int i = 0;i < 50;i++)arr[i] = new Pair(-1, -1);
//
//// 2차원
//        Pair[][] arr = new Pair[50][50];
//        for(int i = 0;i < 50;i++)for(int j = 0;j < 50;j++)arr[i][j] = new Pair(-1, -1);
//
//// 3차원
//        Pair[][][] arr = new Pair[50][50][50];
//        for(int i = 0;i < 50;i++)for(int j = 0;j < 50;j++)for(int k = 0;k < 50;k++)arr[i][j][k] =  new Pair(-1, -1);
//
//< 배열과 컬렉션의 융합 >
//        위와 마찬가지로 Arrays.fill() 메서드를 사용하면 안된다!
//        ArrayList<Integer>[] list = new ArrayList[10];
//        for(int i = 0;i < 10;i++)list[i] = new ArrayList<>();
//
//        list[2].add(3);
//
//< 특수문자 사용 >
//특수 문자를 그대로 표시하고 싶은 경우 문자 앞에 \을 붙여줘야 한다.
//        1. \ 표시 => \\ 입력.
//        2. “ 표시 => \” 입력.
//
//< ,(콤마)가 들어있는 출력의 테크닉 >
//        자료구조상에서 위치가 마지막일 때만 ,를 추가하지 않는 코드를 반복문 내부에 넣자.
//        sb.append("[");
//        while (!q.isEmpty()) {
//        sb.append(q.peek());
//        q.poll();
//
//        if (!q.isEmpty()) {
//        sb.append(", ");
//        }
//        }
//        sb.append("]\n"); // [1, 2, 3, 58]
//
//< 모듈러 연산 >
//(a + b) % M = (a % M + b % M) % M
//        (a - b) % M = (a % M - b % M + M) % M
//        (a * b) % M = ((a % M) * (b % M)) % M
//
//        (a / b) % M = ((a % M) * (b^(-1) % M)) % M
//        => ((a % M) * (b^(M - 2) % M)) % M  // M이 매우 클 경우, b^(M – 2)를 구할 때, 절반씩 쪼개서 구하면 O(logM) 만에 구할 수 있다.
//
//< 최댓값 OR 최솟값으로 초기화하기 >
//        각 래퍼 클래스의 static 변수를 사용한다.
//        int num = Integer.MAX_VALUE;
//        long num2 = Long.MIN_VALUE;
//
//< 브루트 포스 >
//완전탐색 기법이다. ‘깊이’나 ‘탐색’의 개념의 아니더라도 모든 경우의 수를 다 대입해보는 방법이면 브루트포스에 속한다.
//
//< 백트래킹 >
//아래의 두 조건을 만족하는 알고리즘을 백트래킹 알고리즘이라고 한다.
//        1. 솔루션을 찾는 과정에서 valid한 후보인지 계속 검증하며, invalid한 해에 대해 빠르게 포기한다.
//        2. 이미 지나온 곳으로 다시 돌아가서 다른 가능성을 시도해본다.
//
//        [ DFS vs 백트래킹 ]
//        둘은 목표하고자 하는 바가 다르다.
//        DFS : 깊이 우선 탐색하여 모든 노드를 방문하는 것을 목표로 한다.
//        백트래킹 : 불필요한 탐색을 하지 않기 위해, 유망하지 않은 경우의 수를 줄이는 것을 목표로 한다.
//
//        즉, DFS는 완전 탐색을 기본으로 하는 그래프 순회 기법으로, 모든 노드를 방문하는 것을 목표로 한다. 따라서, 불필요할 것 같은 경로를 사전에 차단하거나 하는 등의 행동이 없으므로 경우의 수를 줄이지 못한다. 반면, 백트래킹은 불필요한 탐색을 하지 않고, 이전 단계로 돌아와 다른 후보 해를 탐색해 나가는 방법이다. 즉, 일단 가보고 후보해가 될 수 없으면 다음 단계로 진행하지 않고 되돌아 나온다.
//
//< 분할 정복 >
//해결하고자 하는 문제를 통째로 놓고 푸는 것이 아니고, 문제를 작은 크기의 동일한 문제들로 분할해서 각각의 작은 문제를 순환적으로 해결하는 방법을 말한다.
//
//        [ 분할 정복 vs DP ]
//        둘 다 큰 문제를 동일한 작은 문제로 분할해서 푸는 것은 똑같다. 그러나 결정적인 차이점은 작은 문제가 중복이 일어나는지 여부이다. 분할 정복은 단지 작은 문제로 나누어 푸는 방법이지만, DP는 작은 문제들이 반복해서 쓰인다는 것을 이용해 한번만 메모이제이션하고 중복을 피한다.
//
//< 다이나믹 프로그래밍 >
//문제를 작은 크기의 동일한 문제들로 분할해서 각각의 작은 문제를 순환적으로 해결하는 방법을 말하며 이 때, 모든 작은 문제들은 한번만 풀어야 한다. 따라서 정답을 구한 작은 문제를 어딘가에 메모해 놓고(메모이제이션), 추후에 다시 동일한 작은 문제에 접근했을 때, 앞서 저장한 결과값을 이용한다.
//
//        [ 분할 정복 vs DP ]
//        둘 다 큰 문제를 동일한 작은 문제로 분할해서 푸는 것은 똑같다. 그러나 결정적인 차이점은 작은 문제가 중복이 일어나는지 여부이다. 분할 정복은 단지 작은 문제로 나누어 푸는 방법이지만, DP는 작은 문제들이 반복해서 쓰인다는 것을 이용해 한번만 메모이제이션하고 중복을 피한다
//
//        [ DP 구현 패턴 ]
//        1. 함수의 반환 값이 항상 0 이상이라는 점을 이용해 캐시를 모두 -1로 초기화. 그러나 만약 함수의 반환 값이 음수일 수도 있다면 다른 방법 사용.
//        2. 값이 -1이 아니라면 이미 계산된 값이기 때문에 바로 리턴하도록 처리.
//        3. ret 초기값 설정.
//        4. 논리적인 실질적 코드(답 계산)를 구상하고 꼭 필요한 요소만 캐시로 저장한다.
//        5. 기저 사례를 처리. 입력의 범위를 벗어난 경우 등
//        ex)
//        int cache[2500][2500];
//
//        int func(int a, int b){
//        if(...) return ...;
//
//        int ret = cache[a][b];
//        if(ret != -1)return ret;
//
//// ret 초기값 설정.
//        ret = xxxx;
//
//        // 답 계산(실질적 코드)
//
//        return cache[a][b] = ret;
//        }
//
//        ※ BOJ 11054 문제 보기 => 풀이의 핵심 : 기본값을 1로 세팅해줘야 한다!
//        ※ BOJ 2629 문제 보기 => 풀이의 핵심 : 절댓값으로 DP를 저장한다.
//
//        정말 불가피한 경우에만 재귀가 아닌 for문을 통해서 DP를 채우는 방식을 택하자.
//
//< DP 경로 역추적 >
//        먼저 역추적이 없을 때 답을 구하는 코드부터 전부 다 작성한 후, 하나씩 변경하면서 추적 코드를 삽입한다.
//
//        ※ BOJ 14003 문제 보기
//
//< 이분 탐색 >
//[ 정렬되어 있는 ] 리스트에서 특정한 값을 찾을 때, 절반씩 쪼개면서 탐색해가는 분할정복 탐색 방법.
//
//        시간복잡도 : O(logn)
//
//        ex) BOJ 2110 코드 보기
//
//        [ 특정 값 찾기 ]
//        직접적으로 구현하지 않고, 아래의 lower_bound 메서드로 구현하자. 그것을 이용할 때 원소의 존재 여부 판단은 아래와 같다. pos를 lower_bound를 통해 리턴된 값이라고 하면
//        if(pos == list.size() || arr[pos] != num) // 못찾음.
//        else // 찾음.
//
//        이분 탐색에는 변형된 방법이 존재한다. 이것은 특정 값을 찾기 보다는 가장 답에 근접한 것을 찾을 때 주로 사용하는데 Lower_bound와 Upper_bound가 그것이다.
//
//        [ Lower_bound ]
//        원하는 값보다 같거나 큰 값이 처음으로 나오는 위치를 반환해준다.
//
//        주의 1. 결과가 제일 마지막일 때
//        ex) if( lower_bound(3) == list.size() ) then XXX
//        주의 2. 정확한 값을 찾으려 할 때, 인덱스에 일치하는 값이 없는 경우.
//        ex) if(arr[lower_bound(3)] != num) then XXX
//        int lower_bound(int x) {
//        int s = 0, e = list.size(); // 원하는 값이 리스트의 모든 값 보다 클 때, 그보다 뒤의 인덱스를 반환해야 하므로.
//
//        while (s < e) {
//        int mid = (s + e) / 2;
//
//        if(arr[mid] < x)s = mid + 1;
//        else if(arr[mid] > x)e = mid;
//        else e = mid;
//        }
//        return s;
//        }
//
//        [ Upper_bound ]
//        원하는 값보다 큰 값이 처음으로 나오는 위치를 반환해준다.
//        결과가 제일 마지막일 때 주의해서 처리하자.
//        ex) if( upper_bound(3) == list.size() ) then XXX
//        int upper_bound(int x) {
//        int s = 0, e = list.size(); // 원하는 값이 리스트의 모든 값 보다 클 때, 그보다 뒤의 인덱스를 반환해야 하므로.
//
//        while (s < e) {
//        int mid = (s + e) / 2;
//
//        if(arr[mid] < x)s = mid + 1;
//        else if(arr[mid] > x)e = mid;
//        else s = mid + 1;
//        }
//        return s;
//        }
//
//        ** 중요 **
//        문제의 변수 값이 터무니 없이 큰 경우는 십중팔구 이분탐색 문제거나 분할정복 문제이다. 명심하자. 이 두 알고리즘으로도 떠오르지 않으면 브루트포스로 그냥 풀자.
//
//< LIS >
//https://jason9319.tistory.com/113
//
//        [ 주의 ]
//        리스트에 들어있는 값은 LIS를 이루는 요소와 무관하다.
//        수열상에서 뒤에 있던 원소가 먼저 들어온 원소보다 lower_bound로 탐색 된 최적의 위치가 앞에 있을 수도 있기 때문이다.
//
//        시간복잡도 : O(nlogn)
//
//        [ 역추적을 통해 값 뿐만 아니라 리스트 찾기 ]
//        먼저 역추적이 없을 때 답을 구하는 코드부터 전부 다 작성한 후, 하나씩 변경하면서 추적 코드를 삽입한다.
//
//        ex) BOJ 14003 코드 보기
//
//< LCS >
//https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
//        시간복잡도 : O(n^2)
//
//        [ 역추적을 통해 값 뿐만 아니라 문자열 찾기 ]
//        위쪽 : 2
//        대각선 위 : 1
//        왼쪽 : 0
//
//        ex) BOJ 9252 코드 보기
//
//< 그리디 알고리즘 >
//이 알고리즘은 미래를 생각하지 않고, 각 단계에서 가장 최선의 선택을 하는 기법이다. 이렇게 각 단계에서 최선의 선택을 한 것이 전체적으로도 최선이길 바라는 알고리즘인 것이다.
//        당연히 모든 경우에서 그리디 알고리즘이 통하는 것은 아니다. 그리디하게 해도 문제될 것이 없음이 증명될 때만 사용할 수 있는 개념이다.
//
//< 유클리드 호제법 >
//A와 B의 최대공약수를 G라고 하자.
//        A = a * G, B = b * G 로 표현할 수 있다.
//
//        A > B 라고 할 때, A % B = (a * G) % (b * G) = a * G - x * b * G = (a - bx) * G 로 표현할 수 있다. ( a - bx < G 인 가장 큰 x를 택한 것이다. )
//        즉, A % B 의 최대공약수도 G인 것이다.
//
//        따라서 A > B일 때, GCD(A, B) = GCD(B, A % B) 인 것이다.
//static int GCD(int a, int b) {
//        if(b == 0)return a;
//
//        return GCD(b, a % b);
//        }
//
//
//
//
//
//
//
//
//
//
////////////////////////////////////////////////////////////////////////////////////////////
//
//< Knapsack(냅색) >
//        0/1 knapsack이 대표적이다.
//        : 일정 가치와 무게가 있는 짐들을 배낭에 넣을 때, 가치의 합이 최대가 되도록 짐을 고르는 방법을 찾는 문제. (단, 짐 하나당 넣을 수 있는 최대개수는 1개이다.)
//// dp[n][k] : n번째 물건까지 고려했을 때, 무게 k를 써서 얻을 수 있는 최대 가치
//        1. n을 안 쓰는 경우 : dp[n - 1][k]
//        2. n을 쓰는 경우 : dp[n - 1][k - weight[n]] + value[n] ( k >= weight[n] 일 때 )
//        => 1, 2 중 최댓값이 dp[n][k]의 답이다.
//
//        ex) BOJ 12865 코드 보기
//
//< BFS & DFS >
//        [ BFS ]
//        루트 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법이다.
//
//        시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회 방법이다. 즉, 깊게(deep) 탐색하기 전에 넓게(wide) 탐색하는 것이다.
//
//        두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 선택한다.
//
//        ex) BOJ 2606 코드 보기(인접 리스트), BOJ 7569 코드 보기(방향 벡터)
//
//        [ DFS ]
//        루트 노드에서 시작해서 다음 가지로 넘어가기 전에 해당 가지를 완벽하게 탐색하는 방법이다.
//
//        즉, 넓게(wide) 탐색하기 전에 깊게(deep) 탐색하는 것이다.
//
//        미로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 이곳으로부터 다른 방향으로 다시 탐색을 진행하는 방법과 유사하다.
//
//        ex) BOJ 2606 코드 보기
//
//< 다익스트라 알고리즘 >
//최단경로를 구하는 알고리즘이다.
//        음의 간선은 사용할 수 없다.
//
//        [ 과정 ]
//        1. 출발 노드를 설정한다.
//        2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장한다.
//        3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택한다.
//        4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신한다.
//        5. 3 ~ 4를 반복한다.
//
//        시간복잡도 : O(ElogV)
//
//        DP 배열, INF 값 설정에 주의하자!! 덧셈 연산이 내부 과정에 있는데 최댓값을 넘어버릴 수 있다.
//        MAX 값을 넘을 수 있으므로 항상 long 타입으로 설정하자.
//
//        ex) BOJ 1753 코드 보기
//
//< 베르만포드 알고리즘 >
//최단경로를 구하는 알고리즘이다.
//        음의 간선을 사용할 수 있다.
//
//        https://ssungkang.tistory.com/entry/Algorithm-%EB%B2%A8%EB%A7%8C%ED%8F%AC%EB%93%9CBellman-Ford-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
//
//        시간복잡도 : O(VE)
//
//        DP 배열, INF 값 설정에 주의하자!! 덧셈 연산이 내부 과정에 있는데 최댓값을 넘어버릴 수 있다.
//        MAX 값을 넘을 수 있으므로 항상 long 타입으로 설정하자.
//
//        ex) BOJ 11657 코드 보기
//
//< 플로이드 워셜 알고리즘 >
//        위의 최단경로 알고리즘들은 하나의 정점에서 다른 모든 정점까지의 최단 거리를 구하는 알고리즘이지만, 이 알고리즘은 한 번 실행하여 모든 노드 간 최단 경로를 구할 수 있다.
//        그래프에 음수 사이클만 존재하지 않으면, 음의 가중치를 갖는 간선이 존재해도 상관이 없다.
//
//        시간복잡도 : O(N^3)
//
//        ex) BOJ 11404 코드 보기
//
//< 투 포인터 >
//
//그림처럼 시작점의 위치와 끝점의 위치를 각각 하나의 변수에 담아서 조작하는 알고리즘이다.
//
//        초기 상태에는 두가지 경우가 있다.
//        1. 시작점을 제일 앞, 끝점을 제일 뒤에서 시작하는 경우
//        2. 시작점과 끝점을 모두 제일 앞에서 시작하는 경우
//
//        시간복잡도 : O(N)
//
//        ** 그러나 투 포인터 문제를 보고, 투 포인터의 세부적인 로직을 설계하기는 힘들 것이다.
//        이럴 때는 이분탐색을 이용해서 풀자.
//        시간복잡도는 O(NlogN)으로 늘어나지만 시간제한에는 충분히 들어갈 수 있다.
//        LowerBound or UpperBound를 사용해서 원하는 위치의 +-1 위치를 찾는 것이다.
//        물론 순서대로 정렬이 되어 있어야 한다.!!
//
//        ex) BOJ 2470, BOJ 1806 코드 보기
//
//        ※ 주의!
//        동일한 값을 여러 번 쓰는 것에 주의하자! 동일한 인덱스를 사용할 수 없다!!
//        중복된 케이스가 존재할 수 있다. 그럴 때 나누기 2를 해야하는 것을 생각하자!
//
//
//
//
//
//
/////
//< 트리 순회 >
//ex) BOJ 1991 코드 보기.
//
//        세그먼트트리 공부 후 세그먼트트리 + 레이지 프로퍼게이션도 공부하기
//
//
//
//
//        */