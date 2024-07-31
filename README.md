# react-native-material-datetimepicker

A Native Date and Time Picker library for react native which uses Jetpack Compose Material 3 Date and Time Pickers under the hood.

## Installation

```sh
npm install react-native-material-datetimepicker
```

## Usage

```js
import { MaterialDatetimepicker } from 'react-native-material-datetimepicker';

// ...

<MaterialDatetimepicker
  defaultDate={pickerState.date}
  onCancel={() => console.log('cancel')}
  isVisible={true}
  onConfirm={(val) => console.log(val)}
  confirmText="Confirm"
  displayMode="picker"
  pickerType="date"
/>;
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
