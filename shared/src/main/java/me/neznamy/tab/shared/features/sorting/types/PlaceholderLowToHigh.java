package me.neznamy.tab.shared.features.sorting.types;

import me.neznamy.tab.shared.platform.TabPlayer;
import me.neznamy.tab.shared.features.sorting.Sorting;
import org.jetbrains.annotations.NotNull;

/**
 * Sorting by a numeric placeholder from lowest to highest
 */
public class PlaceholderLowToHigh extends SortingType {

    /**
     * Constructs new instance with given parameters.
     *
     * @param   sorting
     *          Sorting feature
     * @param   sortingPlaceholder
     *          Placeholder to sort by
     */
    public PlaceholderLowToHigh(Sorting sorting, String sortingPlaceholder) {
        super(sorting, "PLACEHOLDER_LOW_TO_HIGH", sortingPlaceholder);
    }

    @Override
    public String getChars(@NotNull TabPlayer p) {
        if (!valid) return "";
        String output = setPlaceholders(p);
        p.sortingData.teamNameNote += "\n-> " + sortingPlaceholder + " returned \"&e" + output + "&r\". &r";
        return compressNumber(DEFAULT_NUMBER + parseDouble(sortingPlaceholder, output, 0, p));
    }

    @Override
    public int getPosition(@NotNull TabPlayer p) {
        if (!valid) return 0;
        String output = setPlaceholders(p);
        p.sortingData.teamNameNote += "\n-> " + sortingPlaceholder + " returned \"&e" + output + "&r\". &r";
        return (int) (DEFAULT_NUMBER - parseDouble(sortingPlaceholder, output, 0, p));
    }
}