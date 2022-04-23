package com.chengfei.base.enum_about.enum_implements;

public enum Season implements TestInterface {
    SPRING{
        @Override
        public void show() {
            System.out.println("这是春天。。。");
        }
    },
    SUMMER{
        @Override
        public void show() {
            System.out.println("这是夏天。。。");
        }
    },
    AUTUMN{
        @Override
        public void show() {
            System.out.println("这是秋天。。。");
        }
    },
    WINTER{
        @Override
        public void show() {
            System.out.println("这是冬天。。。");
        }
    };

//    @Override
//    public void show() {
//
//    }

    public static void main(String[] args) {
        Season winter = Season.WINTER;
        System.out.println(winter);
        winter.show();
    }
}
