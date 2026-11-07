package org.example;

public class Score {


        private int score = 100;

        public Score(){


        }

        public void deductScore(){
                score = score-1;
        }

        public void addScore(){
                score = score+10;
        }

        public int getScore(){

                return score;
        }

        public int maxScore(){
                return 0;
        }
}