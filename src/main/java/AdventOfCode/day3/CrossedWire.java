package AdventOfCode.day3;

public class CrossedWire {


    // we get the input as instructions
    /*

    what we can do is map this out as coordinates. Both wires go from the same spot.
    so in the first one start at 0,0 (x,y)
    if instruction is Rn
    0 + n, 0
    if instruction is Ln
    0 - n, 0
    if instruction is Un
    0, 0 + n
    if instruction is Dn
    0, 0 - n

    that way we get a coordinate of the end position

    But then we need to get all of the intersections.

    Maybe we store all of the coordinates of the path. Then compare both paths by filtering where they are the same. Then see which out
    of those coordinates are closest to 0,0

    so if it is Rn
    then we would have to store n number of coordinates
    e.g.
    origin = 0,0
    R5
    store = 0,0 1,0 2,0 3,0 4,0 5,0
    U2
    5,1 5,2
    L6
    4,2 3,2 2,2 1,2 0,2 -1,2

    so the end list would be = 0,0 1,0 2,0 3,0 4,0 5,0 5,1 5,2 4,2 3,2 2,2 1,2 0,2 -1,2
    for just the instructions R5,U2,L6

    ------------------------

    for loop for each line
        then we loop though each instruction
            then we convert each instruction to a coordinate (updating from the previous coordinate)
            loop for each coordinate in the instruction
                then add that coordinate to the path
        add the path to the array of paths
        end
    end

    Once that is done

    compare all paths coordinates and filter to only the coordinates that are the same

    then compare the origin coordinate to all the filtered coordinates to see which one has the closest intersection
    to the origin

    but we use the manhattan distance to compare. -> (x1 - x2) + (y1 - y2)


    INSTRUCTION
    direction
    number of movements


     */


}
