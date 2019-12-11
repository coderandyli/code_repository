package com.coderandyli.jvm.chapter03.section_02;

/**
 * Created by lizhen on 2019-12-11
 */
public class FinalizeEsccapeGC {
    public static FinalizeEsccapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, I am still alive");
    }

    /**
     * 不建议使用，可以忘记该方法的存在
     *   因为执行代价有点高，不确定性大，无法保证各个对象的调用顺序
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEsccapeGC.SAVE_HOOK = this;
    }

    public static void main(String args[]) throws InterruptedException {
        SAVE_HOOK = new FinalizeEsccapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.1秒以等待它
        Thread.sleep(100);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, I am dead");
        }

        // 下面这段代码与上面的完全相同，但这次自救失败了
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.1秒以等待它
        Thread.sleep(100);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no, I am dead");
        }
    }
}
