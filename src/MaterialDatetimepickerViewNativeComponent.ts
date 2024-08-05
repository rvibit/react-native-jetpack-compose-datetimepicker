import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { HostComponent, ViewProps } from 'react-native';
import type {
  DirectEventHandler,
  Double,
  WithDefault,
} from 'react-native/Libraries/Types/CodegenTypes';

type SelectedDate = Readonly<{
  date: Double;
}>;
interface NativeProps extends ViewProps {
  defaultDate?: Double;
  isVisible: boolean;
  onConfirm?: DirectEventHandler<SelectedDate>;
  onCancel?: DirectEventHandler<{}>;
  confirmText?: string;
  cancelText?: string;
  displayMode?: WithDefault<'picker' | 'input', 'picker'>;
  pickerType?: WithDefault<'date' | 'time', 'date'>;
  themeVarient?: WithDefault<'light' | 'dark' | 'system', 'system'>;
  dynamicColors?: boolean;
}

export default codegenNativeComponent<NativeProps>(
  'MaterialDatetimepickerView'
) as HostComponent<NativeProps>;
