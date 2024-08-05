# react-native-jetpack-compose-datetimepicker

A Native Date and Time Picker library for react native which uses Jetpack Compose Material3 Date and Time Pickers under the hood. It uses react Native Fabric Component (New Architecture only)

## NOTE

This package uses React Natiev new architecture's Fabric Component so it'll only work if your app has new architechture enabled in **android/gradle.properties** file.

## Installation

```sh
npm install react-native-jetpack-compose-datetimepicker
```

## Usage

```js
import { MaterialDatetimepicker } from 'react-native-jetpack-compose-datetimepicker';

// ...

<MaterialDatetimepicker
  defaultDate={new Date()}
  onCancel={() => console.log('cancel')}
  isVisible={true} //true|false -> manage with useState
  onConfirm={(val) => console.log(val)} // val is Date object
  confirmText="Confirm"
  displayMode="picker" // picker | input
  pickerType="date" // date | time
  themeVarient="dark" // light | dark | system    ->(default value is system means it follows system setting)
  dynamicColors={false} // true | false (default is true)
/>;
```

## Features

- Date Picker/ Time Picker
- Inout Mode and Picker Mode
- Light and Dark Theme based support
- Dynamic Theme support based on wallpaper colors (Material You)
- Props autocompletion (Typescript)

## Screenshots/Demo

Check example folder for demo code. You can run the demo using this command

```sh
yarn example
```

OR

```sh
npm run example
```

<img src="https://github.com/user-attachments/assets/8fbd0df7-ad3c-4d6e-9f77-81b9a0271fbb" width="258">
<img src="https://github.com/user-attachments/assets/d82c0312-7665-4b10-97f4-8b4c6afe6a57" width="258">
<img src="https://github.com/user-attachments/assets/e812cb1a-53b9-414c-b5b5-f8cf59d0182e" width="258">

https://github.com/user-attachments/assets/7d535fbe-ad9f-4fcf-a80e-0cf0a82a767b

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
