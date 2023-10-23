function fetchCharacterDetails() {
    const selectedCharacter = $("#characterSelector").val();
    if (selectedCharacter) {
        $.ajax({
            url: `/getCharacterDetails?characterName=${selectedCharacter}`,
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

function clearCharacterDetails() {
    // Clear the character details
    $("#characterDetails").empty();

    // Reset the select tag
    $("#characterSelector").val('Select...');
}