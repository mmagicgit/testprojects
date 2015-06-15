Crafty.init(500, 350, document.getElementById('game'));
Crafty.e('Floor, 2D, Canvas, Color').attr({x: 0, y: 350, w: 350, h: 1}).color('#F00');

var Player = {
    Black: "Black",
    Green: "Green"
};

var player = Player.Black;
var maxColumn = 6;
var maxLine = 5;
var matrix = [[]];

for (var column = 0; column <= maxColumn; column++) {
    matrix[column] = [];
    for (var line = 0; line <= maxLine; line++) {
        matrix[column][line] = "Empty";
    }
}

Crafty.bind("KeyDown", function (e) {
    var column = e.key - 49;
    if (column < 0 || column > maxColumn) {
        return;
    }
    var line = nextLineIndex(matrix[column]);
    if (line > maxLine) {
        return;
    }

    var squareColor = player == Player.Black ? '#F00' : 'green';
    var gravityTo = line == 0 ? 'Floor' : createItemName(column, line - 1);

    Crafty.e(createItemName(column, line) + ', 2D, Canvas, Color, Gravity').attr({
        x: column * 50,
        y: 0,
        w: 50,
        h: 50
    }).color(squareColor).gravity(gravityTo);

    matrix[column][line] = player;

    if (checkWinner(column, line)) {
        alert(player + " wins!")
    }

    player = (player == Player.Black ? Player.Green : Player.Black);
});

function createItemName(column, line) {
    return "x" + column + "" + (line);
}

function nextLineIndex(columnArray) {
    for (var index = 0; index < maxColumn; index++) {
        if (columnArray[index] == "Empty") {
            return index;
        }
    }
    return maxColumn;
}

function checkWinner(column, line) {
    return checkVertical(column, line) || checkHorizontal(line) || checkAscendingDiagonal(column, line) || checkDescendingDiagonal(column, line);
}

function checkVertical(column, line) {
    if (line < 3) {
        return false
    }
    for (var index = line; index >= line - 3; index--) {
        if (matrix[column][index] != player) {
            return false;
        }
    }
    return true;
}

function checkHorizontal(line) {
    var counter = 0;
    for (var index = 0; index < maxColumn; index++) {
        if (matrix[index][line] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
        }
    }
    return false;
}

function checkAscendingDiagonal(column, line) {
    var startColumn = column;
    var startLine = line;
    while (startColumn > 0 && startLine > 0) {
        startColumn = startColumn - 1;
        startLine = startLine - 1;
    }
    var counter = 0;
    for (; startColumn <= maxColumn && startLine <= maxLine; startColumn++, startLine++) {
        if (matrix[startColumn][startLine] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
        }
    }
    return false;
}

function checkDescendingDiagonal(column, line) {
    var startColumn = column;
    var startLine = line;
    while (startColumn < maxColumn && startLine > 0) {
        startColumn = startColumn + 1;
        startLine = startLine - 1;
    }
    var counter = 0;
    for (; startColumn >= 0 && startLine <= maxLine; startColumn--, startLine++) {
        if (matrix[startColumn][startLine] == player) {
            counter++;
            if (counter == 4) {
                return true;
            }
        } else {
            counter = 0;
        }
    }
    return false;
}