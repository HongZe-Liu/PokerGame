import java.util.*;

public class Doudizhu {
    // 创建集合用于存储数据
    static HashMap<Integer,String> poker = new HashMap<>(); // 存储扑克牌的编号与对应的牌面值
    static ArrayList<Integer> list = new ArrayList<>(); // 用于存储所有扑克牌的编号

    static {
        initPoker();
    }

// 初始化牌面
    private static void initPoker(){
        // 创建花色和牌面
        String[] suits ={"♦", "♣", "♥", "♠"};
        String[] ranks ={"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int index = 1; // 遍历的编号

        // 外循环遍历花色
        for(String suit : suits){
            // 内循环遍历点数
            for(String rank : ranks){
                poker.put(index,suit + rank); // 组合花色和点数，并存入 HashMap
                list.add(index);
                index++;
            }
        }
        // 添加大小王
        poker.put(index,"Joker Black"); // 黑色大王
        list.add(index++);
        poker.put(index,"Joker red"); // 红色大王
        list.add(index);
    }

// 洗牌和发牌
    public Doudizhu(){
        // 洗牌：运用Collections.shuffle() 打乱集合中元素的顺序
        Collections.shuffle(list);
        // 创建集合用于储存每个玩家的牌
        TreeSet<Integer> lord = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> player1 = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> player2 = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> player3 = new TreeSet<>(Comparator.reverseOrder());

        // 发牌逻辑
        for(int i = 0; i < list.size(); i++){
            if(i < 3){
                lord.add(list.get(i)); // 最后三张是地主牌
            } else if(i < 20){
                player1.add(list.get(i)); // 玩家1的牌
            } else if(i < 37){
                player2.add(list.get(i)); // 玩家2的牌
            } else{
                player3.add(list.get(i)); // 玩家3的牌
            }
        }
        // 打印牌
            lookpoker("地主", lord);
            lookpoker("西施", player1);
            lookpoker("貂蝉", player2);
            lookpoker("火舞", player3);
    }

// 查看牌面
public void lookpoker(String name, TreeSet<Integer> cards){
    System.out.print(name + ": ");
    for(Integer card : cards){
        System.out.print(poker.get(card) + " ");
    }
    System.out.println(); // 换行方便阅读
    }
}
