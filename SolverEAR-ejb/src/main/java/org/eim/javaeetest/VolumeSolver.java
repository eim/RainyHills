package org.eim.javaeetest;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author eim
 */
@Stateless
@EJB(name="java:global/Solver", beanInterface=Solver.class)
public class VolumeSolver implements Solver {

    /**
     *
     * Method have to calculate the volume of "container"
     * with water in abstract units.
     *
     * Time complexity of the algorithm?
     * The <b>time</b> required by this method is proportional to the number of
     * basic operation that will be performed.
     *
     * Basic operations such as:
     * plus
     * minus
     * multiply
     * devision
     * comparison
     * assignment
     * read (from array for example)
     *
     * This algorithm uses only one loop through the array to detect its volume.
     * This loop contains (7 + 16N) basic operations in the worst case.
     * The constant value 7 we can omit because in huge array it can't impact
     * on the calculation time.
     * It means complexity is equal to 16N where N is the array size.
     *
     * In complexity theory we are using next basic scores of an algorithm:
     *
     * 1. C - a constant
     * 2. log(log(N))
     * 3. log(N)
     * 4. N^C, 0<C<1
     * 5. N
     * 6. N*log(N)
     * 7. N^C, C>1
     * 8. C^N, C>1
     * 9. N!
     *
     * This algorithm corresponds to the fifth value in the table.
     * The complexity of the algorithm is not worse than O(N).
     *
     * Memory complexity of an algorithm?
     * We won't allocate an additional memory O(1).
     *
     * @param src - array of heights of surface
     * @return volume in units.
     */
    @Override
    public int calculate(int[] src) {
        /* value of the left border */
        int left = 0;                           // 1
        /* value of the right border */
        int right = src.length-1;               // 2 3 4
        /* value of the left max value that
           wasn't added into the volume yet */
        int leftMax = 0;                        // 5
        /* value of the right max value that
           wasn't added into the volume yet */
        int rightMax = 0;                       // 6
        /* result value */
        int volume = 0;                         // 7

        /* we are going to calculate until
           borders have a space between them */
        while(left < right) {                   // 8
          /* If current left value more than
             previous left max value */
          if (src[left] > leftMax) {            // 9 10
            /* we will use current value
               as max left value */
            leftMax = src[left];                // 11 12
          }
          /* If current right value more than
             previous fight max value */
          if (src[right] > rightMax) {          // 13 14
            /* we will use current value
               as max right value */
            rightMax = src[right];              // 15 16
          }

          /* we have to add to the volume the lower
             value among maximum values */
          if (leftMax > rightMax) {             // 17
            /* If left max more than right max
              will add difference between right max
              and current value to the volume */
            volume += rightMax - src[right];    // 18 19 20 21
            /* and move right border left */
            right--;                            // 22 23
          } else {                              // in this case "or" operation has
            /* If right max more than left max  // the same numbers of basic operations
              have to add difference between left max
              and current value to the volume */
            volume += leftMax - src[left];
            /* and move left border right */
            left++;
          }
        }
        return volume;
    }

}
