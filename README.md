# Livecounts Spigot Plugin

This is a Spigot plugin for Minecraft servers that utilizes the Livecounts.lol API to fetch channel estimates for YouTube channels.

## Features

- Fetches subscriber count, view count, and other statistics from the Livecounts.lol API.
- Provides methods to extract specific data from the API response.
- Includes an API wrapper class for easy integration into Spigot plugins.

## Installation

1. Download the latest release JAR file from the [releases page](https://github.com/LivecountsLOL/LivecountsLOL-SpigotAPI/releases).
2. Place the JAR file in the `plugins` folder of your Spigot server.
3. Restart the server.

## Installation

To use the LiveCounts API Wrapper in your Spigot plugin project, you can include the `LivecountsAPIWrapper.jar` file as a dependency. Additionally, ensure that the plugin is installed and enabled on your Spigot server.

## API Documentation

### `LivecountsAPIWrapper` Class

The `LivecountsAPIWrapper` class provides methods for interacting with the Livecounts.lol API and fetching channel estimates.

#### `getChannelEstimates(String channelId)`

Fetches channel estimates for the specified YouTube channel ID.

- Parameters:
  - `channelId`: The ID of the YouTube channel for which to fetch estimates.
- Returns:
  - A `ChannelEstimates` object containing the fetched estimates.

#### `ChannelEstimates` Class

The `ChannelEstimates` class represents the estimates fetched from the Livecounts.lol API.

##### Methods

- `getSubscriberCount()`: Returns the subscriber count estimate.
- `getViewCount()`: Returns the view count estimate.
- `getVideoCount()`: Returns the video count estimate.
- `getEstimatedDataContents()`: Returns additional data contents included in the estimate response.

## Usage

Once installed, the plugin will automatically fetch channel estimates from the Livecounts.lol API. You can access the fetched data through the provided API wrapper class.

```java
// Example usage in a Spigot plugin
LivecountsAPIWrapper apiWrapper = new LivecountsAPIWrapper("YOUR_API_KEY");
try {
    LivecountsAPIWrapper.ChannelEstimates estimates = apiWrapper.getChannelEstimates("CHANNEL_ID");
    long subscriberCount = estimates.getSubscriberCount();
    long viewCount = estimates.getViewCount();
    long videoCount = estimates.getVideoCount();
    // Use the fetched data as needed
} catch (IOException | ParseException e) {
    // Handle exceptions
}
```

Make sure to replace "YOUR_API_KEY" with your actual Livecounts.lol API key and "CHANNEL_ID" with the ID of the YouTube channel for which you want to fetch estimates.

## Dependencies
json-simple - JSON parsing library.
Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or create a pull request.

## License
This project is licensed under the MIT License.