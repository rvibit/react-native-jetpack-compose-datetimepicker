#import <React/RCTViewManager.h>
#import <React/RCTUIManager.h>
#import "RCTBridge.h"

@interface MaterialDatetimepickerViewManager : RCTViewManager
@end

@implementation MaterialDatetimepickerViewManager

RCT_EXPORT_MODULE(MaterialDatetimepickerView)

- (UIView *)view
{
  return [[UIView alloc] init];
}

RCT_EXPORT_VIEW_PROPERTY(color, NSString)

@end
