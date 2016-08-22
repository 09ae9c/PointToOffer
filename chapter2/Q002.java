package chapter2;

/**
 * Created by tc on 6/14/16.实现单例模式(Singleton)
 * 设计一个类,只能生成该类的一个实例
 * 参考文章:http://www.importnew.com/21141.html
 */
public class Q002 {

//------懒汉式,线程不安全--------------------------------
// 多线程环境下可能会产生多个实例
//-----------------------------------------------------
//    private static Q002 instance;
//
//    private Q002() {
//    }
//
//    public static Q002 getInstance() {
//        if (instance == null) {
//            instance = new Q002();
//        }
//        return instance;
//    }
//-----------------------------------------------------


//-----懒汉式,线程安全-----------------------------------
// 并不高效,同步操作会在每次调用时都执行,而实际只需
// 要在第一次调用时需要同步操作
//-----------------------------------------------------
//    private static Q002 instance;
//
//    private Q002() {
//    }
//
//    public static synchronized Q002 getInstance() {
//        if (instance == null) {
//            instance = new Q002();
//        }
//        return instance;
//    }


//-----双重检验锁----------------------------------------
// 解决了每次都执行同步操作带来的问题,但是仍然不够完美
//------------------------------------------------------
//    private volatile static Q002 instance;
//
//    private Q002() {
//    }
//
//    public static Q002 getInstance() {
//        if (instance == null) {
//            synchronized (Q002.class) {
//                if (instance == null) {
//                    instance = new Q002();
//                }
//            }
//        }
//        return instance;
//    }


//----饿汉式------------------------------------------------
// 将实例申明为 static 和 final,在第一次类加载到内存中时就会初始化
// 所以创建实例是线程安全的
//---------------------------------------------------------
//    private static final Q002 instance = new Q002();
//
//    private Q002() {
//    }
//
//    public static Q002 getInstance() {
//        return instance;
//    }


//----静态内部类---------------------------------------------
// 由于 Singleton 是私有的,只有 getInstance() 方法能访问它,因此它
// 是懒汉式,同时读取实例时不会进行同步,没有性能缺陷,推荐使用
//----------------------------------------------------------
    private static class Singleton {
        private static final Q002 INSTANCE = new Q002();
    }

    private Q002() {
    }

    public static final Q002 getInstance() {
        return Singleton.INSTANCE;
    }

}
