class FooBar {
    private int n;

    Semaphore printF;
    Semaphore printB;
    public FooBar(int n) {
        this.n = n;
        printF = new Semaphore(1);
        printB = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            printF.acquire();
        	printFoo.run();
            printB.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            printB.acquire();
        	printBar.run();
            printF.release();

        }
    }
}