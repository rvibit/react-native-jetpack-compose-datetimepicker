# react-native-jetpack-compose-datetimepicker

A Native Date and Time Picker library for react native which uses Jetpack Compose Material3 Date and Time Pickers under the hood. It uses react Native Fabric Component (New Architecture only)

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
  onConfirm={(val) => console.log(val)}
  confirmText="Confirm"
  displayMode="picker"
  pickerType="date"
/>;
```

## Screenshots/Demo

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
