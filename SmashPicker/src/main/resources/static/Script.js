function showSearchOptions() {
    const searchOptions = $("#searchOptions");
    searchOptions.show();
}

function hideSearchOptions() {
    const searchOptions = $("#searchOptions");
    searchOptions.hide();
}

function showInitialMessage() {
    const initialMessage = $("#initialMessage");
    initialMessage.show();
}

function hideInitialMessage() {
    const initialMessage = $("#initialMessage");
    initialMessage.hide();
}

function handleFetch(characterName) {
    if (characterName) {
        $.ajax({
            url: `/getCharacterDetails?characterName=${characterName}`,
            dataType: 'json',
            success: function (data) {
                // Get the Handlebars template
                const source = $("#character-details-template").html();
                const template = Handlebars.compile(source);

                // Render the template with the JSON data
                const html = template(data);

                // Display the rendered HTML in the "characterDetails" div
                $("#characterDetails").html(html);
            },
            error: function (error) {
                console.error("Error fetching character details:", error);
            }
        });
    }
}

function fetchCharacterDetails() {
    const selectedCharacter = $("#characterSelector").val();
    handleFetch(selectedCharacter);
    hideSearchOptions();
    hideInitialMessage();
}

function fetchRelatedCharacterDetails(characterName) {
    handleFetch(characterName);
}


function clearCharacterDetails() {
    // Clear the character details
    $("#characterDetails").empty();

    // Reset the select tag
    $("#characterSelector").val('');

    showInitialMessage();
}

function setSearch(option) {
    var characterName = $(option).text();
    $("#characterSelector").val(characterName);
    showSearchOptions();
}

$(document).ready(function () {
    const characterSelector = $("#characterSelector");
    const noResultsOption = $(".option.no-results");
    const submitButton = $("button[type='submit']");

    // Add an input event listener to characterSelector
    characterSelector.on("input", function () {
        const searchText = $(this).val().trim().toLowerCase();
        let anyResults = false;

        // Iterate through the options and show/hide them based on the search text
        $(".option").each(function () {
            const optionText = $(this).text().toLowerCase();
            if (optionText.includes(searchText)) {
                $(this).show();
                anyResults = true;
            } else {
                $(this).hide();
            }
        });

        // Show or hide the "No results" option
        if (searchText && !anyResults) {
            noResultsOption.show();
        } else {
            noResultsOption.hide();
        }

        // Show or hide search-options based on the search input
        if (searchText) {
            showSearchOptions();
        } else {
            hideSearchOptions()
        }
    });
});