import { useCallback } from 'react';
import MaterialDatetimepickerView from './MaterialDatetimepickerViewNativeComponent';
import type { NativeSyntheticEvent } from 'react-native';
import type { Double } from 'react-native/Libraries/Types/CodegenTypes';
export * from './MaterialDatetimepickerViewNativeComponent';

interface DatePickerPorps {
  defaultDate?: Date;
  isVisible: boolean;
  onConfirm?: (date: Date) => void;
  onCancel?: () => void;
  confirmText?: string;
  cancelText?: string;
  displayMode?: 'picker' | 'input';
  pickerType?: 'date' | 'time';
}
type PickerEvent = NativeSyntheticEvent<
  Readonly<{
    date: Double;
  }>
>;

export function MaterialDatetimepicker(props: DatePickerPorps) {
  const date = props.defaultDate?.getTime() ?? new Date().getTime();
  const onConfirm = useCallback(
    (e: PickerEvent) => {
      const selectedDate = new Date(e.nativeEvent.date);
      props.onConfirm?.(selectedDate);
    },
    [props]
  );
  return (
    <MaterialDatetimepickerView
      {...props}
      defaultDate={date}
      onConfirm={onConfirm}
    />
  );
}
