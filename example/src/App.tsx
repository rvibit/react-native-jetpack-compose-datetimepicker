import { useState } from 'react';
import { Pressable, StyleSheet, TextInput, View } from 'react-native';
import { MaterialDatetimepicker } from 'react-native-jetpack-compose-datetimepicker';

export default function App() {
  const [pickerState, setPickerState] = useState({
    showDatePicker: false,
    showTimePicker: false,
    date: new Date('2024-09-10'),
    time: new Date('2024-09-10 16:30'),
  });
  return (
    <>
      <View style={styles.container}>
        <Pressable
          style={styles.input}
          onPress={() =>
            setPickerState({ ...pickerState, showDatePicker: true })
          }
        >
          <TextInput
            placeholder="Select Date"
            value={pickerState.date.toLocaleDateString()}
            editable={false}
          />
        </Pressable>
        <Pressable
          style={styles.input}
          onPress={() =>
            setPickerState({ ...pickerState, showTimePicker: true })
          }
        >
          <TextInput
            // style={styles.input}
            placeholder="Select Time"
            value={pickerState.time.toLocaleTimeString()}
            editable={false}
          />
        </Pressable>
      </View>
      <MaterialDatetimepicker
        defaultDate={pickerState.date}
        onCancel={() => {
          console.log('cancel');
          setPickerState({ ...pickerState, showDatePicker: false });
        }}
        isVisible={pickerState.showDatePicker}
        onConfirm={(val) => {
          setPickerState({ ...pickerState, date: val, showDatePicker: false });
          console.log(val);
        }}
        confirmText="Confirm"
        displayMode="picker"
        pickerType="date"
      />
      <MaterialDatetimepicker
        defaultDate={pickerState.time}
        onCancel={() => {
          console.log('cancel');
          setPickerState({ ...pickerState, showTimePicker: false });
        }}
        isVisible={pickerState.showTimePicker}
        onConfirm={(val) => {
          setPickerState({ ...pickerState, time: val, showTimePicker: false });
          console.log(val);
        }}
        confirmText="Confirm"
        displayMode="picker"
        pickerType="time"
      />
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    flex: 1,
    alignItems: 'center',
    justifyContent: 'space-between',
    backgroundColor: '#fff',
    padding: 10,
    gap: 10,
  },

  input: {
    flex: 1,
    padding: 10,
    borderColor: '#dcdcdc',
    borderWidth: 1,
    borderRadius: 5,
  },
});
