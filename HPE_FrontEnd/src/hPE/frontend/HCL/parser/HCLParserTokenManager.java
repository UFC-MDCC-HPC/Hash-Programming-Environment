/* Generated By:JavaCC: Do not edit this line. HCLParserTokenManager.java */
package hPE.frontend.HCL.parser;
import hPE.frontend.HCL.symbol_table.*;

/** Token Manager. */
public class HCLParserTokenManager implements HCLParserConstants
{
        public static int numOfComment = 0;

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7ff806L) != 0L)
         {
            jjmatchedKind = 23;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x7ff806L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 1;
            return 1;
         }
         return -1;
      case 2:
         if ((active0 & 0x7ff806L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 2;
            return 1;
         }
         return -1;
      case 3:
         if ((active0 & 0x7ec806L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 3;
            return 1;
         }
         if ((active0 & 0x13000L) != 0L)
            return 1;
         return -1;
      case 4:
         if ((active0 & 0x7ec006L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 4;
            return 1;
         }
         if ((active0 & 0x800L) != 0L)
            return 1;
         return -1;
      case 5:
         if ((active0 & 0x7e8006L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 5;
            return 1;
         }
         if ((active0 & 0x4000L) != 0L)
            return 1;
         return -1;
      case 6:
         if ((active0 & 0x7e8004L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 6;
            return 1;
         }
         if ((active0 & 0x2L) != 0L)
            return 1;
         return -1;
      case 7:
         if ((active0 & 0x7e8004L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 7;
            return 1;
         }
         return -1;
      case 8:
         if ((active0 & 0x80000L) != 0L)
            return 1;
         if ((active0 & 0x768004L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 8;
            return 1;
         }
         return -1;
      case 9:
         if ((active0 & 0x400004L) != 0L)
            return 1;
         if ((active0 & 0x368000L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 9;
            return 1;
         }
         return -1;
      case 10:
         if ((active0 & 0x248000L) != 0L)
            return 1;
         if ((active0 & 0x120000L) != 0L)
         {
            jjmatchedKind = 23;
            jjmatchedPos = 10;
            return 1;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 9:
         return jjStopAtPos(0, 25);
      case 32:
         return jjStopAtPos(0, 26);
      case 40:
         return jjStopAtPos(0, 7);
      case 41:
         return jjStopAtPos(0, 8);
      case 44:
         return jjStopAtPos(0, 4);
      case 46:
         return jjStopAtPos(0, 5);
      case 47:
         return jjMoveStringLiteralDfa1_0(0x18000000L);
      case 58:
         return jjStopAtPos(0, 6);
      case 61:
         return jjStopAtPos(0, 3);
      case 91:
         return jjStopAtPos(0, 9);
      case 93:
         return jjStopAtPos(0, 10);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x220000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x440002L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x4004L);
      case 113:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x100800L);
      case 117:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(1, 27);
         break;
      case 47:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x4004L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x442000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x21000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x2L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2800L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x204004L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x10002L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000L);
      case 118:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 16, 1);
         break;
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x100800L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x2L);
      case 104:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x280004L);
      case 109:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 112:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000L);
      case 116:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 1);
         return jjMoveStringLiteralDfa5_0(active0, 0x400004L);
      case 104:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x2a0000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x2L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x44000L);
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x200000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x2L);
      case 102:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000L);
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x4L);
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x40000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x500000L);
      case 116:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(5, 14, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x28000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x608000L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x20004L);
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000L);
      case 110:
         return jjMoveStringLiteralDfa7_0(active0, 0x40000L);
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000L);
      case 115:
         if ((active0 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(6, 1, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x20000L);
      case 101:
         return jjMoveStringLiteralDfa8_0(active0, 0x80000L);
      case 109:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000L);
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x100004L);
      case 116:
         return jjMoveStringLiteralDfa8_0(active0, 0x608000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa9_0(active0, 0x40000L);
      case 105:
         return jjMoveStringLiteralDfa9_0(active0, 0x308000L);
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x400000L);
      case 114:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(8, 19, 1);
         break;
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x20004L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 110:
         return jjMoveStringLiteralDfa10_0(active0, 0x40000L);
      case 111:
         return jjMoveStringLiteralDfa10_0(active0, 0x208000L);
      case 114:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(9, 22, 1);
         break;
      case 115:
         if ((active0 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(9, 2, 1);
         break;
      case 117:
         return jjMoveStringLiteralDfa10_0(active0, 0x20000L);
      case 122:
         return jjMoveStringLiteralDfa10_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
private int jjMoveStringLiteralDfa10_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 101:
         return jjMoveStringLiteralDfa11_0(active0, 0x100000L);
      case 110:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(10, 15, 1);
         else if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(10, 21, 1);
         break;
      case 114:
         return jjMoveStringLiteralDfa11_0(active0, 0x20000L);
      case 116:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(10, 18, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
private int jjMoveStringLiteralDfa11_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(9, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0);
      return 11;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(11, 17, 1);
         break;
      case 114:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(11, 20, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(10, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 5;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  kind = 23;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 2:
                  if (curChar == 10 && kind > 24)
                     kind = 24;
                  break;
               case 3:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  if ((0x2400L & l) != 0L && kind > 24)
                     kind = 24;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 23)
                     kind = 23;
                  jjCheckNAdd(1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 5 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjStopStringLiteralDfa_2(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_2(int pos, long active0)
{
   return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0), pos + 1);
}
private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x40000000L);
      case 47:
         return jjMoveStringLiteralDfa1_2(0x20000000L);
      default :
         return jjMoveNfa_2(1, 0);
   }
}
private int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_2(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         break;
      case 47:
         if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         break;
      default :
         break;
   }
   return jjStartNfa_2(0, active0);
}
private int jjMoveNfa_2(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 10 && kind > 24)
                     kind = 24;
                  break;
               case 2:
                  if ((0x2400L & l) != 0L && kind > 24)
                     kind = 24;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(1, 0);
}
private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 10 && kind > 24)
                     kind = 24;
                  break;
               case 2:
                  if ((0x2400L & l) != 0L && kind > 24)
                     kind = 24;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\145\170\164\145\156\144\163", 
"\151\155\160\154\145\155\145\156\164\163", "\75", "\54", "\56", "\72", "\50", "\51", "\133", "\135", 
"\163\154\151\143\145", "\146\162\157\155", "\165\156\151\164", "\151\155\160\157\162\164", 
"\143\157\155\160\165\164\141\164\151\157\156", "\144\141\164\141", "\141\162\143\150\151\164\145\143\164\165\162\145", 
"\145\156\166\151\162\157\156\155\145\156\164", "\161\165\141\154\151\146\151\145\162", 
"\163\171\156\143\150\162\157\156\151\172\145\162", "\141\160\160\154\151\143\141\164\151\157\156", 
"\145\156\165\155\145\162\141\164\157\162", null, null, null, null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT", 
   "INSIDE_COMMENT_2", 
   "INSIDE_COMMENT", 
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, 2, 1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffL, 
};
static final long[] jjtoSkip = {
   0x1ff000000L, 
};
static final long[] jjtoSpecial = {
   0x7000000L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[5];
private final int[] jjstateSet = new int[10];
private final StringBuffer jjimage = new StringBuffer();
private StringBuffer image = jjimage;
private int jjimageLen;
private int lengthOfMatch;
protected char curChar;
/** Constructor. */
public HCLParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public HCLParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 5; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   switch(curLexState)
   {
     case 0:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 32)
       {
          jjmatchedKind = 32;
       }
       break;
     case 2:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_2();
       if (jjmatchedPos == 0 && jjmatchedKind > 31)
       {
          jjmatchedKind = 31;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else 
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 24 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                                             if (curLexState==INSIDE_COMMENT_2) SwitchTo(DEFAULT);
         break;
      case 27 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                numOfComment=1;
         break;
      case 29 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                numOfComment++;
         break;
      case 30 :
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                 numOfComment--; if (numOfComment==0) SwitchTo(DEFAULT);
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

}
