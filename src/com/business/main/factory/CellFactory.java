package com.business.main.factory;

import com.business.main.entity.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellFactory {

    private List<Cell> cells;

    public Cell getCellType(String cellValue) {
        for (Cell cell : getAllCells()) {
            if (cell.getCellValue().equalsIgnoreCase(cellValue)) {
                return cell;
            }
        }

        return null;
    }

    private List<Cell> getAllCells() {
        if (cells == null) {
            cells = new ArrayList<>();
        }

        return cells;
    }

    public void addCell(Cell cell) {
        getAllCells().add(cell);
    }

}
