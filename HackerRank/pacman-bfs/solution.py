import copy


def bfs_search():
    # get pacmans starting position
    start_string_array = input().split()
    start_x = int(start_string_array[0])
    start_y = int(start_string_array[1])

    # get food location - the destination
    goal_string_array = input().split()
    goal_x = int(goal_string_array[0])
    goal_y = int(goal_string_array[1])

    # get board size (amount of rows)
    grid_string_array = input().split()
    rows_amount = int(grid_string_array[0])

    # get grid and save it
    grid = []
    for i in range(0, rows_amount):
        grid.append(list(map(str, input())))

    queue = [[start_x, start_y, []]]  # add pacmans starting position to the queue

    opened_node = []  # for storing currently opened nodes
    paths = None  # for storing paths

    # queue has to get empty (all possible paths discovered)
    while len(queue) > 0:
        current_x, current_y, current_routes = queue.pop(0)  # get first node from the queue
        routes = copy.deepcopy(current_routes)  # making a deepcopy so original doesn't get modified
        routes.append([current_x, current_y])  # add current to routes
        opened_node.append([current_x, current_y])  # add current to currently opened nodes as its opened

        if current_x == goal_x and current_y == goal_y:  # we have reached the destination
            paths = routes  # save current route to paths and break out from the loop
            break

        for direction in [[-1, 0], [0, -1], [0, 1], [1, 0]]:  # go through all neighbours in order: UP, LEFT, RIGHT, DOWN
            next_x = current_x + direction[0]
            next_y = current_y + direction[1]
            if next_x < 0 or next_x >= rows_amount or next_y < 0 and next_y >= rows_amount:
                # continue only when given coordinates are within the grid bounds
                continue

            if grid[next_x][next_y] == "-" or grid[next_x][next_y] == ".":  # if the location has not been visited
                grid[next_x][next_y] = 'v'  # mark the location visited
                queue.append([next_x, next_y, routes])  # add location to the queue, to visit its neighbours

    print(str(len(opened_node)))  # print paths length
    for location in opened_node:
        # print all locations coordinates
        print(str(location[0]) + " " + str(location[1]))

    print(str(len(paths) - 1))
    for location in paths:
        print(str(location[0]) + " " + str(location[1]))


if __name__ == '__main__':
    bfs_search()
