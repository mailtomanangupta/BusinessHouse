package com.business.main.util;

public enum  HotelRating {

    SILVER {
        @Override
        public int getUpgradationCost() {
            return 100;
        }

        @Override
        public int getValue() {
            return 200;
        }

        @Override
        public int getRent() {
            return 50;
        }

        @Override
        public HotelRating upgrade() {
            return GOLD;
        }
    },
    GOLD {
        @Override
        public int getUpgradationCost() {
            return 200;
        }

        @Override
        public int getValue() {
            return 300;
        }

        @Override
        public int getRent() {
            return 150;
        }

        @Override
        public HotelRating upgrade() {
            return PLATINUM;
        }
    },
    PLATINUM {
        @Override
        public int getUpgradationCost() {
            return 0;
        }

        @Override
        public int getValue() {
            return 500;
        }

        @Override
        public int getRent() {
            return 300;
        }

        @Override
        public HotelRating upgrade() {
            return PLATINUM;
        }
    };

    public abstract int getUpgradationCost();
    public abstract int getValue();
    public abstract int getRent();
    public abstract HotelRating upgrade();

}
