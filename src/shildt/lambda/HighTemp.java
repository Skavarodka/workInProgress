package shildt.lambda;

//Класс для хранения максимальной температуры за день

 class HighTemp {
     private int hTemp;

     HighTemp(int ht) {
         hTemp = ht;
     }

// 11 возвратить логическое значение true, если
//11 вызывающий объект типа HighTemp содержит такую
//11 же температуру, как и у объекта ht2

     boolean sameTemp(HighTemp ht2) {
         return hTemp == ht2.hTemp;
     }

// 11 возвратить логическое значение true, если
//11 вызывающий объект типа HighTemp содержит
//11 температуру ниже, чем у объекта ht2

     boolean lessThanTemp(HighTemp ht2) {
         return hTemp < ht2.hTemp;
     }
}
